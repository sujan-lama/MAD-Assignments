package com.miu.mdp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.miu.mdp.data.local.converters.Converters
import com.miu.mdp.data.local.dao.*
import com.miu.mdp.data.local.entity.*

@Database(
    entities = [
        UserEntity::class,
        UserDetailEntity::class,
        ExperienceEntity::class,
        EducationEntity::class,
        CertificationEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun userDetailDao(): UserDetailDAO
    abstract fun certificationDao(): CertificationDAO
    abstract fun educationDao(): EducationDAO
    abstract fun experienceDao(): ExperienceDAO
    abstract fun aboutDAO(): AboutDAO
    abstract fun userWithAllDataDao(): UserWithAllDataDAO

    companion object {
        const val DATABASE_NAME = "cv_builder_db"
    }
}