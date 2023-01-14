package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toCertificationModel
import com.miu.mdp.data.mapper.toCertificationEntity
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.domain.repository.CertificationRepository
import javax.inject.Inject

class CertificationRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : CertificationRepository {

    private val certificationDAO = appDatabase.certificationDao()

    override suspend fun getCertification(email: String): List<Certification> {
        return certificationDAO.getCertification(email)?.map { it.toCertificationModel() }?.toList()
            ?: emptyList()
    }

    override suspend fun insertCertification(certification: Certification) {
        certificationDAO.insert(certification.toCertificationEntity())
    }

    override suspend fun deleteCertification(certification: Certification) {
        certificationDAO.delete(certification.toCertificationEntity())
    }


}