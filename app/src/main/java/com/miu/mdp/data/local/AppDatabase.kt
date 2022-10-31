package com.miu.mdp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.miu.mdp.data.local.converters.Converters
import com.miu.mdp.data.local.dao.UserDAO
import com.miu.mdp.data.local.dao.UserDetailDAO
import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        UserDetailEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun userDetailDao(): UserDetailDAO

    companion object {
        const val DATABASE_NAME = "cv_builder_db"
    }
}