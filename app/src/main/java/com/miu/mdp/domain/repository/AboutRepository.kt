package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.About

interface AboutRepository {
    fun getAboutData(email: String): About?
}