package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.AboutData
import com.miu.mdp.domain.model.AboutDTO

fun AboutData.toAboutDTO() = AboutDTO(
    aboutMe = userDetail.aboutMe,
    education = education.map { it.toEducationDTO() }.toList(),
    certification = certification.map { it.toCertificationDTO() }.toList()
)
