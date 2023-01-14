package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toHomeDataModel
import com.miu.mdp.domain.model.HomeData
import com.miu.mdp.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : HomeRepository {

    private val homeDAO = appDatabase.homeDao()
    override suspend fun getHomeData(email: String): HomeData? {
        return try {
            val homeData = homeDAO.getHomeData(email) ?: return null
            homeData.toHomeDataModel()
        } catch (e: Exception) {
            null
        }
    }

}
