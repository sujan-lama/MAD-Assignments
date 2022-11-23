package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.CertificationEntity
import com.miu.mdp.domain.model.CertificationDTO

fun CertificationEntity.toCertificationDTO() = CertificationDTO(
    id = id,
    certificationName = certificationName,
    image = image,
    certificationAuthority = certificationAuthority,
    certificationDate = certificationDate,
    email = email
)

fun CertificationDTO.toCertificationEntity() = CertificationEntity(
    id = id,
    certificationName = certificationName,
    image = image,
    certificationAuthority = certificationAuthority,
    certificationDate = certificationDate,
    email = email
)