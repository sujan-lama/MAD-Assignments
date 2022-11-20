package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.domain.model.UserDetailDTO

fun UserDetailEntity.toUserDetailDTO() = UserDetailDTO(
    email = email,
    contact = contact,
    position = position,
    aboutMe = aboutMe,
    careerNote = careerNote,
    experienceMap = experienceMap,
    image = image
)

fun UserDetailDTO.toUserDetailEntity() = UserDetailEntity(
    id = 0,
    image = image,
    position = position,
    email = email,
    contact = contact,
    aboutMe = aboutMe,
    careerNote = careerNote,
    experienceMap = experienceMap
)