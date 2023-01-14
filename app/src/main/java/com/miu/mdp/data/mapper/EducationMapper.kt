package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.EducationEntity
import com.miu.mdp.domain.model.Education

fun EducationEntity.toEducationModel() = Education(
    id = id,
    schoolName = schoolName,
    image = image,
    degree = degree,
    startDate = startDate,
    endDate = endDate,
    email = email
)

fun Education.toEducationEntity() = EducationEntity(
    id = id,
    schoolName = schoolName,
    image = image,
    degree = degree,
    startDate = startDate,
    endDate = endDate,
    email = email
)