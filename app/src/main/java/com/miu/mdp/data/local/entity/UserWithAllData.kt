package com.miu.mdp.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithAllData(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "username",
        entityColumn = "email"
    )
    val userDetail: UserDetailEntity,
    @Relation(
        parentColumn = "username",
        entityColumn = "email"
    )
    val education: List<EducationEntity>,
    @Relation(
        parentColumn = "username",
        entityColumn = "email"
    )
    val experience: List<ExperienceEntity>,
    @Relation(
        parentColumn = "username",
        entityColumn = "email"
    )
    val certification: List<CertificationEntity>
)