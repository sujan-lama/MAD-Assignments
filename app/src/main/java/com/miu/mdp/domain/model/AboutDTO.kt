package com.miu.mdp.domain.model

data class AboutDTO(
    val aboutMe: String,
    val education: List<EducationDTO>,
    val certification: List<CertificationDTO>
)