package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.ExperienceEntity
import com.miu.mdp.domain.model.ExperienceDTO

fun ExperienceEntity.toExperienceDTO() = ExperienceDTO(
    id = id,
    companyName = companyName,
    image = image,
    position = position,
    startDate = startDate,
    endDate = endDate,
    email = email,
    description = description
)

fun ExperienceDTO.toExperienceEntity() = ExperienceEntity(
    id = id,
    companyName = companyName,
    image = image,
    position = position,
    startDate = startDate,
    endDate = endDate,
    email = email,
    description = description
)