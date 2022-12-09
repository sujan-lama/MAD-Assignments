package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.UserEntity

@Dao
interface UserDAO : BaseDAO<UserEntity> {


    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun login(username: String, password: String): UserEntity?

    @Query("SELECT * FROM user WHERE username = :username")
    fun getUser(username: String): UserEntity?
}