package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.UserDTO

interface UserRepository {
    suspend fun login(username: String, password: String): UserDTO?
    suspend fun register(userDTO: UserDTO): Boolean
    suspend fun getUser(): UserDTO?
    suspend fun logout()
}