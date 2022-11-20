package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.EducationDTO

interface EducationRepository {
    suspend fun getEducation(email: String): List<EducationDTO>
    suspend fun insertEducation(educationDTO: EducationDTO)
    suspend fun deleteEducation(educationDTO: EducationDTO)
}