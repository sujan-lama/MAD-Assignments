package com.miu.mdp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "experience",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["username"],
        childColumns = ["email"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ExperienceEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val companyName: String,
    val image: String,
    val position: String,
    val startDate: String,
    val endDate: String,
    val description: String,
    @ColumnInfo(index = true)
    val email: String
)