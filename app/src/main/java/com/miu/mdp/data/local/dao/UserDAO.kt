package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.miu.mdp.data.local.entity.UserEntity

@Dao
interface UserDAO {

    @Insert
    fun insertUser(user: UserEntity)


    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): UserEntity?

}