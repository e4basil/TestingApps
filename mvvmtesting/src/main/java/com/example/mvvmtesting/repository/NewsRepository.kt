package com.example.mvvmtesting.repository

import com.example.mvvmtesting.data.api.NewsService
import com.example.mvvmtesting.data.api.dto.NewsResponseDto
import com.example.mvvmtesting.data.db.NewsDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val api:NewsService,
    private val database: NewsDatabase
) {

    suspend fun fetchArticles(language: String, category: String): NewsResponseDto? {
        return api.getNews(
            country = language,
            category = category,
            page = 0,
            pageSize = 20
        )
    }
}