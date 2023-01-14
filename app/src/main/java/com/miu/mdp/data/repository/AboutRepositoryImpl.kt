package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toAboutModel
import com.miu.mdp.domain.model.About
import com.miu.mdp.domain.repository.AboutRepository
import javax.inject.Inject

class AboutRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : AboutRepository {
    override fun getAboutData(email: String): About? {
        return try {
            appDatabase.aboutDAO().getAboutData(email)?.toAboutModel()
        } catch (e: Exception) {
            null
        }
    }
}
