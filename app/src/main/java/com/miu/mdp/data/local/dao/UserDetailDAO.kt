package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.UserDetailEntity

@Dao
interface UserDetailDAO : BaseDAO<UserDetailEntity> {

    @Query("SELECT * FROM userdetail WHERE email = :email")
    fun getUserDetail(email: String): UserDetailEntity?
}