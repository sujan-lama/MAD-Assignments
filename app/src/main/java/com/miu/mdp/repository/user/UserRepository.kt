package com.miu.mdp.repository.user

import com.miu.mdp.model.User

interface UserRepository {
    suspend fun login(username: String, password: String): Boolean
    suspend fun register(user: User): Boolean
}