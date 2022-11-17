package com.miu.mdp.data.repository

import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toUserData
import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.model.UserDataDTO
import com.miu.mdp.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val sharedPreferenceHelper: SharedPreferenceHelper,
    private val appDatabase: AppDatabase
) : HomeRepository {

    private val userDAO = appDatabase.userWithAllDataDao()
    private val experienceDAO = appDatabase.experienceDao()

    override suspend fun getUser(): User? {
        return sharedPreferenceHelper.user
    }

    override suspend fun getUserWithData(): UserDataDTO? {
        val user = sharedPreferenceHelper.user
        user?.let {
            val userWithAllData = userDAO.loadAll(it.username)
            return userWithAllData.toUserData()
        }
        return null
    }
}
