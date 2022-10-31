package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.UserEntity
import com.miu.mdp.domain.model.User

fun UserEntity.toUser() = User(
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)

fun User.toUserEntity() = UserEntity(
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)