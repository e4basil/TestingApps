package com.example.mvvmtesting.data.api

import com.example.mvvmtesting.data.api.dto.NewsResponseDto
import com.example.mvvmtesting.utils.NetworkingConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {


    @GET("top-headlines")
    suspend fun getNews(@Query("country") country: String = "",
                        @Query("apiKey") apiKey: String = NetworkingConstants.API_KEY,
                        @Query("category") category: String =  "",
                        @Query("page") page: Int = 0,
                        @Query("pageSize") pageSize: Int = 0): NewsResponseDto?
}