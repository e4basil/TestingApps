package com.example.mvvmtesting.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmtesting.data.db.converters.SourceConvertors
import com.example.mvvmtesting.data.db.dao.ArticleDao
import com.example.mvvmtesting.data.db.dao.RemoteKeyDao
import com.example.mvvmtesting.data.db.entities.RemoteKey
import com.example.mvvmtesting.model.Article

@Database(entities = arrayOf(Article::class,RemoteKey::class), version = 1, exportSchema = false)
@TypeConverters(value = arrayOf(SourceConvertors::class))
abstract class NewsDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}