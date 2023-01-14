package com.miu.mdp.domain.model

data class About(
    val aboutMe: String,
    val education: List<Education>,
    val certification: List<Certification>
)