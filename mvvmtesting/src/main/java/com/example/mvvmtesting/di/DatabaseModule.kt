package com.example.mvvmtesting.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmtesting.data.db.NewsDatabase
import com.example.mvvmtesting.data.db.dao.ArticleDao
import com.example.mvvmtesting.data.db.dao.RemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): NewsDatabase {
        return Room
            .databaseBuilder(app, NewsDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticleDao(newsDatabase: NewsDatabase): ArticleDao{
        return newsDatabase.articleDao()
    }

    @Provides
    fun provideRemoteKeysDao(newsDatabase: NewsDatabase): RemoteKeyDao{
        return newsDatabase.remoteKeyDao()
    }
}