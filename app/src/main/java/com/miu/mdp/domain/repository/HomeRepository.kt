package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.model.UserDataDTO

interface HomeRepository {
    suspend fun getUser(): User?
    suspend fun getUserWithData(): UserDataDTO?
}