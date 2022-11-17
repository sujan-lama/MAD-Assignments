package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.EducationEntity

@Dao
interface EducationDAO : BaseDAO<EducationEntity> {

    @Query("SELECT * FROM education WHERE email = :email")
    fun getEducation(email: String): List<EducationEntity>?

}


