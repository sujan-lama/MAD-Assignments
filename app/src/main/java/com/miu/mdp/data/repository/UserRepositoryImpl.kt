package com.miu.mdp.data.repository

import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toUserDTO
import com.miu.mdp.domain.model.UserDTO
import com.miu.mdp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val sharedPreferenceHelper: SharedPreferenceHelper,
    private val appDatabase: AppDatabase
) :
    UserRepository {

    private val dao = appDatabase.userDao()

    override suspend fun login(username: String, password: String): UserDTO? {
        val user = dao.getUser(username, password) ?: return null
        sharedPreferenceHelper.user = user.toUserDTO()
        return user.toUserDTO()
    }

    override suspend fun register(userDTO: UserDTO): Boolean {
        val existingUser = dao.getUser(userDTO.username, userDTO.password)
        if (existingUser != null && existingUser.username == userDTO.username) {
            return false
        }
        return true
    }

    override suspend fun getUser(): UserDTO? {
        return sharedPreferenceHelper.user
    }

    override suspend fun logout() {
        sharedPreferenceHelper.user = null
    }
}

