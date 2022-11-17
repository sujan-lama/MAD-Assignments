package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.ExperienceEntity

@Dao
interface ExperienceDAO : BaseDAO<ExperienceEntity> {

    @Query("SELECT * FROM experience WHERE email = :email")
    fun getExperience(email: String): List<ExperienceEntity>?
}