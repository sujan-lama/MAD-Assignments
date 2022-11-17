package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.miu.mdp.data.local.entity.*
import com.miu.mdp.domain.model.*

@Dao
interface UserWithAllDataDAO {

    @Transaction
    @Query("SELECT * FROM user WHERE username = :email")
    fun loadAll(email: String): UserWithAllData

    @Insert
    fun insertUserDetail(userDetail: UserDetailEntity)


    @Insert
    fun insertExperience(experience: List<ExperienceEntity>)

    @Insert
    fun insertEducation(education: List<EducationEntity>)

    @Insert
    fun insertCertification(certification: List<CertificationEntity>)

    @Transaction
    fun insertUserWithAllData(
        userDetail: UserDetailEntity,
        experience: List<ExperienceEntity>,
        education: List<EducationEntity>,
        certification: List<CertificationEntity>
    ) {
        insertUserDetail(userDetail)
        insertExperience(experience)
        insertEducation(education)
        insertCertification(certification)
    }
}