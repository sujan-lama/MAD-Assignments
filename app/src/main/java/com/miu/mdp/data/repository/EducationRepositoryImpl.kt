package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toEducationModel
import com.miu.mdp.data.mapper.toEducationEntity
import com.miu.mdp.domain.model.Education
import com.miu.mdp.domain.repository.EducationRepository
import javax.inject.Inject

class EducationRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : EducationRepository {
    private val educationDao = appDatabase.educationDao()

    override suspend fun getEducation(email: String): List<Education> {
        return educationDao.getEducation(email)?.map { it.toEducationModel() }?.toList()
            ?: emptyList()
    }

    override suspend fun insertEducation(education: Education) {
        educationDao.insert(education.toEducationEntity())
    }

    override suspend fun deleteEducation(education: Education) {
        educationDao.delete(education.toEducationEntity())
    }
}