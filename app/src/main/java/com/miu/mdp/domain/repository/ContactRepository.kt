package com.miu.mdp.domain.repository

import com.miu.mdp.domain.model.Contact

interface ContactRepository {
    suspend fun getContact(email: String): Contact
}