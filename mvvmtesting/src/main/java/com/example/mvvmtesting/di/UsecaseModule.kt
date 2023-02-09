package com.example.mvvmtesting.di

import com.example.mvvmtesting.repository.NewsRepository
import com.example.mvvmtesting.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: NewsRepository): DataUseCase {
        return DataUseCase(repository)
    }
}