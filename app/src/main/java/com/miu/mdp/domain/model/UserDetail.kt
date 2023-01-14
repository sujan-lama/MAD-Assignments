package com.miu.mdp.domain.model

data class UserDetail(
    val image: String,
    val email: String,
    val contact: Contact,
    val position: String,
    val aboutMe: String,
    val careerNote: String,
    val experienceMap: HashMap<String, List<String>>
)