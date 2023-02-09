package com.example.mvvmtesting.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "article_table")
data class Article(
    @PrimaryKey
    val id: String,
    val url: String,
    val author: String,
    val title: String,
    val description: String,
    val imgUrl: String,
    val date: String,
    val content: String,
    val source: Source?=null,
    var category: String = "",
    var language: String = ""
): Parcelable


@Parcelize
class Source(val name: String=""): Parcelable