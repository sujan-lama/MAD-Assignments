package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toAboutDTO
import com.miu.mdp.domain.model.AboutDTO
import com.miu.mdp.domain.repository.AboutRepository
import javax.inject.Inject

class AboutRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : AboutRepository {
    override fun getAboutData(email: String): AboutDTO {
        return appDatabase.aboutDAO().getAboutData(email).toAboutDTO()
    }
}
