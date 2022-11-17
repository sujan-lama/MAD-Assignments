package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.AboutDTO

interface AboutRepository {
    fun getAboutData(email: String): AboutDTO
}