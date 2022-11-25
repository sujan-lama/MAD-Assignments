package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toHomeDataDTO
import com.miu.mdp.domain.model.HomeDataDTO
import com.miu.mdp.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : HomeRepository {

    private val homeDAO = appDatabase.homeDao()
    override suspend fun getHomeData(email: String): HomeDataDTO? {
        return try {
            val homeData = homeDAO.getHomeData(email) ?: return null
            homeData.toHomeDataDTO()
        } catch (e: Exception) {
            null
        }
    }

}
