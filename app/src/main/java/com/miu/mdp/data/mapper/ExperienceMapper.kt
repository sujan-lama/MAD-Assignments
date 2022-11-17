package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.ExperienceEntity
import com.miu.mdp.domain.model.Experience

fun ExperienceEntity.toExperience() = Experience(
    id = id,
    companyName = companyName,
    image = image,
    position = position,
    startDate = startDate,
    endDate = endDate,
    email = email,
    description = description
)

fun Experience.toExperienceEntity() = ExperienceEntity(
    id = id,
    companyName = companyName,
    image = image,
    position = position,
    startDate = startDate,
    endDate = endDate,
    email = email,
    description = description
)