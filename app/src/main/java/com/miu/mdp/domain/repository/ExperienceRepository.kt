package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.ExperienceDTO

interface ExperienceRepository {
    suspend fun getExperience(email: String): List<ExperienceDTO>
    suspend fun addWorkExperience(experienceDTO: ExperienceDTO)
    suspend fun deleteExperience(experienceDTO: ExperienceDTO)
}