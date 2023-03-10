package com.example.mvvmtesting.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
class RemoteKey(
    @PrimaryKey
    val articleId: String,
    val nextKey: Int?,
    val prevKey: Int?
)