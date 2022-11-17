package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.AboutData
import com.miu.mdp.domain.model.AboutDTO

fun AboutData.toAboutDTO() = AboutDTO(
    aboutMe = userDetail.aboutMe,
    education = education.map { it.toEducation() }.toList(),
    certification = certification.map { it.toCertification() }.toList()
)
