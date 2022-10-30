package com.miu.mdp.di

import android.app.Application
import android.content.Context
import com.miu.mdp.constants.SHARED
import com.miu.mdp.data.SharedPreferenceHelper
import com.miu.mdp.repository.user.UserRepository
import com.miu.mdp.repository.user.UserRepositoryImpl
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
    fun providesUserRepository(sharedPreferenceHelper: SharedPreferenceHelper): UserRepository {
        return UserRepositoryImpl(sharedPreferenceHelper)
    }
}