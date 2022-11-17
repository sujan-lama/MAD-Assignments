package com.miu.mdp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Relation

data class AboutData(
    @ColumnInfo(name = "username")
    val email: String,
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
    val certification: List<CertificationEntity>
)