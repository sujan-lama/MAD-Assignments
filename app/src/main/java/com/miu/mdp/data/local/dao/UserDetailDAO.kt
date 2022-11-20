package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.domain.model.Contact

@Dao
interface UserDetailDAO : BaseDAO<UserDetailEntity> {

    @Query("SELECT * FROM userdetail WHERE email = :email")
    fun getUserDetail(email: String): UserDetailEntity?

    @Query("SELECT contact from userdetail WHERE email = :email")
    fun getContact(email: String): Contact
}