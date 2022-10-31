package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.model.UserDetail

interface UserRepository {
    suspend fun login(username: String, password: String): Boolean
    suspend fun register(user: User): Boolean
    suspend fun isLoggedIn(): Boolean
    suspend fun logout()
}