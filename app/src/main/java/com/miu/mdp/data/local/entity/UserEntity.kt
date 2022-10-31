package com.miu.mdp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    val firstName: String,
    val lastName: String,
    @PrimaryKey
    val username: String,
    val password: String
)

