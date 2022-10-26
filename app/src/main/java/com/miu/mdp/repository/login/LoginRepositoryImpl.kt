package com.miu.mdp.repository.login

import com.miu.mdp.data.SharedPreferenceHelper

class LoginRepositoryImpl(private val sharedPreferenceHelper: SharedPreferenceHelper) :
    LoginRepository {
    override suspend fun login(username: String, password: String): Boolean {
        val user = sharedPreferenceHelper.user ?: return false
        return user.username == username && user.password == password
    }
}