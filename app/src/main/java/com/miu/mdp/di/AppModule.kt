package com.miu.mdp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.miu.mdp.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        val builder = Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
//            .createFromAsset("database/cv_builder.db")
        builder.setQueryCallback(object : RoomDatabase.QueryCallback {
            override fun onQuery(sqlQuery: String, bindArgs: List<Any?>) {
                println("SQL Query: $sqlQuery SQL Args: $bindArgs")
            }
        }) {
            it.run()
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideQuizDAO(appDatabase: AppDatabase) = appDatabase.quizDAO()
}