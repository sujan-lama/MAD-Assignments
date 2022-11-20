package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toCertificationDTO
import com.miu.mdp.data.mapper.toCertificationEntity
import com.miu.mdp.domain.model.CertificationDTO
import com.miu.mdp.domain.repository.CertificationRepository
import javax.inject.Inject

class CertificationRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : CertificationRepository {

    private val certificationDAO = appDatabase.certificationDao()

    override suspend fun getCertification(email: String): List<CertificationDTO> {
        return certificationDAO.getCertification(email)?.map { it.toCertificationDTO() }?.toList()
            ?: emptyList()
    }

    override suspend fun insertCertification(certificationDTO: CertificationDTO) {
        certificationDAO.insert(certificationDTO.toCertificationEntity())
    }

    override suspend fun deleteCertification(certificationDTO: CertificationDTO) {
        certificationDAO.delete(certificationDTO.toCertificationEntity())
    }


}