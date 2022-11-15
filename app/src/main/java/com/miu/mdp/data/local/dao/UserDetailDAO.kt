package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.domain.model.Experience

@Dao
interface UserDetailDAO {

    @Insert
    fun insertUserDetail(userDetail: UserDetailEntity)

    @Query("SELECT * FROM userdetail WHERE email = :email")
    fun getUserDetail(email: String): UserDetailEntity?

    @Query("UPDATE userdetail SET experience = :experience WHERE email = :email")
    fun updateExperience(experience: List<Experience>, email: String)
}