package com.miu.mdp.data.repository

import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.mapper.*
import com.miu.mdp.data.mock.getMockCertification
import com.miu.mdp.data.mock.getMockEducation
import com.miu.mdp.data.mock.getMockExperience
import com.miu.mdp.data.mock.getMockUserDetail
import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val sharedPreferenceHelper: SharedPreferenceHelper,
    private val appDatabase: AppDatabase
) :
    UserRepository {

    private val dao = appDatabase.userDao()
    private val userDataDao = appDatabase.userWithAllDataDao()

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
        dao.insert(user.toUserEntity())
        userDataDao.insertUserWithAllData(
            userDetail = getMockUserDetail(user.username).toUserDetailEntity(),
            experience = getMockExperience(user.username).map { it.toExperienceEntity() }.toList(),
            education = getMockEducation(user.username).map { it.toEducationEntity() }.toList(),
            certification = getMockCertification(user.username)
                .map { it.toCertificationEntity() }
                .toList(),
        )
        return true
    }

    override suspend fun getUser(): User? {
        return sharedPreferenceHelper.user
    }

    override suspend fun logout() {
        sharedPreferenceHelper.user = null
    }
}

