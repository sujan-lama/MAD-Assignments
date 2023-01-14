package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.CertificationEntity
import com.miu.mdp.domain.model.Certification

fun CertificationEntity.toCertificationModel() = Certification(
    id = id,
    certificationName = certificationName,
    image = image,
    certificationAuthority = certificationAuthority,
    certificationDate = certificationDate,
    email = email
)

fun Certification.toCertificationEntity() = CertificationEntity(
    id = id,
    certificationName = certificationName,
    image = image,
    certificationAuthority = certificationAuthority,
    certificationDate = certificationDate,
    email = email
)