package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.Education

interface EducationRepository {
    suspend fun getEducation(email: String): List<Education>
    suspend fun insertEducation(education: Education)
    suspend fun deleteEducation(education: Education)
}