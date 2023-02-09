package com.example.mvvmtesting.data.api.dto

import android.os.Parcelable
import com.example.mvvmtesting.model.Article
import com.example.mvvmtesting.model.Source
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


@Parcelize
data class NewsResponseDto(
    @SerializedName("articles")
    val articles: List<ArticleDto?>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
) : Parcelable

@Parcelize
data class ArticleDto(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("source")
    val source: SourceDto?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?
) : Parcelable

@Parcelize
data class SourceDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
) : Parcelable

fun SourceDto.asModel(): Source {
    return Source(name = name ?:"")
}

fun NewsResponseDto.asModel(): List<Article> {
    return articles!!.map {

        Article(
            id = it?.title+ java.lang.System.currentTimeMillis(),
            url = it?.url?: "",
            author = it?.author ?: "",
            title = it?.title ?: "",
            description = it?.description ?: "",
            imgUrl = it?.urlToImage ?: "",
            date = it?.publishedAt ?: "",
            content = it?.content ?: "",
            source = it?.source?.asModel()
        )
    }
}