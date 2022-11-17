package com.miu.mdp.domain.model

data class UserDataDTO(
    val user: User,
    val userDetail: UserDetail,
    val education: List<Education>,
    val certification: List<Certification>,
    val experience: List<Experience>,
)