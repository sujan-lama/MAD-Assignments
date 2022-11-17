package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.Experience

interface ExperienceRepository {
    suspend fun getExperience(email: String): List<Experience>
    suspend fun addWorkExperience(experience: Experience)
    suspend fun deleteExperience(experience: Experience)
}