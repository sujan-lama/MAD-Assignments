package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.UserWithAllData
import com.miu.mdp.domain.model.UserDataDTO

fun UserWithAllData.toUserData() = UserDataDTO(
    user = user.toUser(),
    userDetail = userDetail.toUserDetail(),
    education = education.map { it.toEducation() },
    certification = certification.map { it.toCertification() },
    experience = experience.map { it.toExperience() }
)

fun UserDataDTO.toUserWithAllData() = UserWithAllData(
    user = user.toUserEntity(),
    userDetail = userDetail.toUserDetailEntity(),
    education = education.map { it.toEducationEntity() },
    certification = certification.map { it.toCertificationEntity() },
    experience = experience.map { it.toExperienceEntity() }
)