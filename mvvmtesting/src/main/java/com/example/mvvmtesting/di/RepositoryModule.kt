package com.example.mvvmtesting.di

import com.example.mvvmtesting.data.api.NewsService
import com.example.mvvmtesting.data.db.NewsDatabase
import com.example.mvvmtesting.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        service: NewsService,
        database: NewsDatabase
    ): NewsRepository {
        return NewsRepository(service, database)
    }
}