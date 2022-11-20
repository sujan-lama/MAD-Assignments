package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.CertificationDTO

interface CertificationRepository {
    suspend fun getCertification(email: String): List<CertificationDTO>
    suspend fun insertCertification(certificationDTO: CertificationDTO)
    suspend fun deleteCertification(certificationDTO: CertificationDTO)
}