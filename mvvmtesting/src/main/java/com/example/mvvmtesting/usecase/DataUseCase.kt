package com.example.mvvmtesting.usecase

import com.example.mvvmtesting.data.api.dto.NewsResponseDto
import com.example.mvvmtesting.data.api.dto.asModel
import com.example.mvvmtesting.model.Article
import com.example.mvvmtesting.repository.NewsRepository
import com.example.mvvmtesting.utils.ResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataUseCase @Inject constructor(
    private val dataRepository: NewsRepository
)  {

    suspend fun fetchArticles(language: String, category: String): Flow<ResponseData<List<Article>>> {
        return flow {
            emit(ResponseData.Loading)
            val articles = dataRepository.fetchArticles(language, category)
            if (articles==null){
                emit(ResponseData.Error())
            }else{
                emit(ResponseData.Success(articles.asModel()))
            }
        }.catch {
            emit(ResponseData.Error())
        }.flowOn(Dispatchers.IO)
    }
}