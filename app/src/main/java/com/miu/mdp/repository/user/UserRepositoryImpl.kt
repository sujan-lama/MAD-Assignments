package com.miu.mdp.repository.user

import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.model.User

class UserRepositoryImpl(private val sharedPreferenceHelper: SharedPreferenceHelper) :
    UserRepository {
    override suspend fun login(username: String, password: String): Boolean {
        val user = sharedPreferenceHelper.user ?: return false
        return user.username == username && user.password == password
    }

    override suspend fun register(user: User): Boolean {
        val existingUser = sharedPreferenceHelper.user
        if (existingUser != null && existingUser.username == user.username) {
            return false
        }
        sharedPreferenceHelper.user = user
        return true
    }
}