package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.AboutDataRelation
import com.miu.mdp.domain.model.About

fun AboutDataRelation.toAboutModel() = About(
    aboutMe = userDetail.aboutMe,
    education = education.map { it.toEducationModel() }.toList(),
    certification = certification.map { it.toCertificationModel() }.toList()
)
