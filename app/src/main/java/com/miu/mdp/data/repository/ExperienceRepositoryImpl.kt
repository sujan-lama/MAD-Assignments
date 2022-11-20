package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toExperienceDTO
import com.miu.mdp.data.mapper.toExperienceEntity
import com.miu.mdp.domain.model.ExperienceDTO
import com.miu.mdp.domain.repository.ExperienceRepository
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : ExperienceRepository {

    private val experienceDAO = appDatabase.experienceDao()

    override suspend fun getExperience(email: String): List<ExperienceDTO> {
        return experienceDAO.getExperience(email)?.map { it.toExperienceDTO() }?.toList()
            ?: emptyList()
    }

    override suspend fun addWorkExperience(experienceDTO: ExperienceDTO) {
        experienceDAO.insert(experienceDTO.toExperienceEntity())
    }

    override suspend fun deleteExperience(experienceDTO: ExperienceDTO) {
        experienceDAO.delete(experienceDTO.toExperienceEntity())
    }
}
