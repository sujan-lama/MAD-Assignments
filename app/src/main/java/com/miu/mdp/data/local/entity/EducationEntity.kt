package com.miu.mdp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "education",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["username"],
        childColumns = ["email"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class EducationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val schoolName: String,
    val image: String,
    val degree: String,
    val startDate: String,
    val endDate: String,
    @ColumnInfo(index = true)
    val email: String
)