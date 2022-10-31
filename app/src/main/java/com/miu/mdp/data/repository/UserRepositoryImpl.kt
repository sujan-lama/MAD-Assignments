package com.miu.mdp.data.repository

import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.toUser
import com.miu.mdp.data.mapper.toUserEntity
import com.miu.mdp.data.mock.getFakeUserDetail
import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val sharedPreferenceHelper: SharedPreferenceHelper,
    private val appDatabase: AppDatabase
) :
    UserRepository {

    private val dao = appDatabase.userDao()
    private val userDetailDAO = appDatabase.userDetailDao()

    override suspend fun login(username: String, password: String): Boolean {
        val user = dao.getUser(username, password) ?: return false
        sharedPreferenceHelper.user = user.toUser()
        return true
    }

    override suspend fun register(user: User): Boolean {
        val existingUser = dao.getUser(user.username, user.password)
        if (existingUser != null && existingUser.username == user.username) {
            return false
        }
        dao.insertUser(user.toUserEntity())
        userDetailDAO.insertUserDetail(getFakeUserDetail(user.username))
        return true
    }

    override suspend fun isLoggedIn(): Boolean {
        return sharedPreferenceHelper.user != null
    }

    override suspend fun logout() {
        sharedPreferenceHelper.user = null
    }
}

