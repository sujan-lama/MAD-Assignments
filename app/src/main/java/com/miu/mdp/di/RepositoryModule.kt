package com.miu.mdp.di

import com.miu.mdp.data.repository.*
import com.miu.mdp.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindExperienceRepository(experienceRepositoryImpl: ExperienceRepositoryImpl): ExperienceRepository

    @Binds
    @Singleton
    abstract fun bindEducationRepository(educationRepositoryImpl: EducationRepositoryImpl): EducationRepository

    @Binds
    @Singleton
    abstract fun bindCertificationRepository(certificationRepositoryImpl: CertificationRepositoryImpl): CertificationRepository

    @Binds
    @Singleton
    abstract fun bindAboutRepository(aboutRepositoryImpl: AboutRepositoryImpl): AboutRepository
}