package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toEducationDTO
import com.miu.mdp.data.mapper.toEducationEntity
import com.miu.mdp.domain.model.EducationDTO
import com.miu.mdp.domain.repository.EducationRepository
import javax.inject.Inject

class EducationRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : EducationRepository {
    private val educationDao = appDatabase.educationDao()

    override suspend fun getEducation(email: String): List<EducationDTO> {
        return educationDao.getEducation(email)?.map { it.toEducationDTO() }?.toList()
            ?: emptyList()
    }

    override suspend fun insertEducation(educationDTO: EducationDTO) {
        educationDao.insert(educationDTO.toEducationEntity())
    }

    override suspend fun deleteEducation(educationDTO: EducationDTO) {
        educationDao.delete(educationDTO.toEducationEntity())
    }
}