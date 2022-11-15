package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.Experience
import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.model.UserDetail

interface HomeRepository {
    suspend fun getUser(): User?
    suspend fun getUserDetail(): UserDetail?
    suspend fun addWorkExperience(experience: Experience)
}