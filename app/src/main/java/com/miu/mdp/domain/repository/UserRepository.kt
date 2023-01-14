package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String): User?
    suspend fun register(user: User): Boolean
    suspend fun getUser(): User?
    suspend fun logout()
}