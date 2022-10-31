package com.miu.mdp.data.repository

import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.data.local.dao.UserDetailDAO
import com.miu.mdp.data.mapper.toUserDetail
import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.model.UserDetail
import com.miu.mdp.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val sharedPreferenceHelper: SharedPreferenceHelper,
    private val userDetailDAO: UserDetailDAO,

    ) : HomeRepository {
    override suspend fun getUser(): User? {
        return sharedPreferenceHelper.user
    }

    override suspend fun getUserDetail(): UserDetail? {
        val user = sharedPreferenceHelper.user ?: return null
        return userDetailDAO.getUserDetail(user.username)?.toUserDetail()
    }
}
