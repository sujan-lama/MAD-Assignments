package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.HomeDataDTO

interface HomeRepository {
    suspend fun getHomeData(email: String): HomeDataDTO?
}