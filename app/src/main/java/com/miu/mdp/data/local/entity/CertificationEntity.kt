package com.miu.mdp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "certification",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["username"],
        childColumns = ["email"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CertificationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val certificationName: String,
    val image: String,
    val certificationAuthority: String,
    val certificationDate: String,
    @ColumnInfo(index = true)
    val email: String
)