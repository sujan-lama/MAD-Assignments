package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toExperience
import com.miu.mdp.data.mapper.toExperienceEntity
import com.miu.mdp.domain.model.Experience
import com.miu.mdp.domain.repository.ExperienceRepository
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : ExperienceRepository {

    private val experienceDAO = appDatabase.experienceDao()

    override suspend fun getExperience(email: String): List<Experience> {
        return experienceDAO.getExperience(email)?.map { it.toExperience() }?.toList()
            ?: emptyList()
    }

    override suspend fun addWorkExperience(experience: Experience) {
        experienceDAO.insert(experience.toExperienceEntity())
    }

    override suspend fun deleteExperience(experience: Experience) {
        experienceDAO.delete(experience.toExperienceEntity())
    }
}
