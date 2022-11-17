package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.Certification

interface CertificationRepository {
    suspend fun getCertification(email: String): List<Certification>
    suspend fun insertCertification(certification: Certification)
    suspend fun deleteCertification(certification: Certification)
}