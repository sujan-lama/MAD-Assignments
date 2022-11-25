package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.UserEntity
import com.miu.mdp.domain.model.UserDTO

fun UserEntity.toUserDTO() = UserDTO(
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)

fun UserDTO.toUserEntity() = UserEntity(
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)