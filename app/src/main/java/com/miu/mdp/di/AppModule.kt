package com.miu.mdp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.miu.mdp.constants.SHARED
import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.repository.HomeRepositoryImpl
import com.miu.mdp.data.repository.UserRepositoryImpl
import com.miu.mdp.domain.repository.HomeRepository
import com.miu.mdp.domain.repository.UserRepository
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
    fun providesSharedPreference(app: Application): SharedPreferenceHelper {
        return SharedPreferenceHelper(
            app.getSharedPreferences(SHARED.NAME, Context.MODE_PRIVATE)
        )
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesUserRepository(
        sharedPreferenceHelper: SharedPreferenceHelper,
        appDatabase: AppDatabase
    ): UserRepository {
        return UserRepositoryImpl(sharedPreferenceHelper, appDatabase)
    }

    @Provides
    @Singleton
    fun providesHomeRepository(
        sharedPreferenceHelper: SharedPreferenceHelper,
        appDatabase: AppDatabase
    ): HomeRepository {
        return HomeRepositoryImpl(sharedPreferenceHelper, appDatabase.userDetailDao())
    }
}