package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.HomeData

interface HomeRepository {
    suspend fun getHomeData(email: String): HomeData?
}