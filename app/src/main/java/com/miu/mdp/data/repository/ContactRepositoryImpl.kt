package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.repository.ContactRepository
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : ContactRepository {
    private val userDetailDAO = appDatabase.userDetailDao()
    override suspend fun getContact(email: String): Contact {
        return userDetailDAO.getContact(email)
    }
}