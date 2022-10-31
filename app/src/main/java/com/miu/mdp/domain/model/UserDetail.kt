package com.miu.mdp.domain.model

data class UserDetail(
    val image: String,
    val email: String,
    val contact: Contact,
    val position: String,
    val education: List<Education>,
    val certification: List<Certification>,
    val aboutMe: String,
    val experience: List<Experience>,
    val careerNote: String,
    val experienceMap: HashMap<String, List<String>>
)