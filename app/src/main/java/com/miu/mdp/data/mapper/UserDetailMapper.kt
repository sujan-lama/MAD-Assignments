package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.domain.model.UserDetail

fun UserDetailEntity.toUserDetail() = UserDetail(
    email = email,
    contact = contact,
    education = education,
    certification = certification,
    aboutMe = aboutMe,
    experience = experience,
    careerNote = careerNote,
    experienceMap = experienceMap
)

fun UserDetail.toUserDetailEntity() = UserDetailEntity(
    id = 0,
    email = email,
    contact = contact,
    education = education,
    certification = certification,
    aboutMe = aboutMe,
    experience = experience,
    careerNote = careerNote,
    experienceMap = experienceMap
)