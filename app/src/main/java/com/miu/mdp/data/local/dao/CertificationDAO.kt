package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.CertificationEntity

@Dao
interface CertificationDAO : BaseDAO<CertificationEntity> {

    @Query("SELECT * FROM certification WHERE email = :email")
    fun getCertification(email: String): List<CertificationEntity>?
}