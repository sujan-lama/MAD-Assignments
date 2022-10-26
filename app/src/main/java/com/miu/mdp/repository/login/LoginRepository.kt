package com.miu.mdp.repository.login

interface LoginRepository {
   suspend fun login(username: String, password: String): Boolean
}