package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.EducationEntity
import com.miu.mdp.domain.model.EducationDTO

fun EducationEntity.toEducationDTO() = EducationDTO(
    schoolName = schoolName,
    image = image,
    degree = degree,
    startDate = startDate,
    endDate = endDate,
    email = email
)

fun EducationDTO.toEducationEntity() = EducationEntity(
    id = 0,
    schoolName = schoolName,
    image = image,
    degree = degree,
    startDate = startDate,
    endDate = endDate,
    email = email
)