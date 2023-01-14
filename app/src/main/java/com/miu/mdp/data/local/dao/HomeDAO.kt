package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.miu.mdp.data.local.entity.*
import com.miu.mdp.domain.model.*

@Dao
interface HomeDAO {

    @Query("SELECT * FROM user WHERE username = :email")
    @Transaction
    fun getHomeData(email: String): HomeDataRelation?

}