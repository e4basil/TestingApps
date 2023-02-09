package com.example.mvvmtesting.data.db.converters

import androidx.room.TypeConverter
import com.example.mvvmtesting.model.Source
import com.google.gson.Gson




class SourceConvertors {

    @TypeConverter
    fun fromSourceToString(type: Source): String? {
        val gson = Gson()
        return gson.toJson(type)
    }

    @TypeConverter
    fun fromStringToSource(type: String): Source? {
        val gson = Gson()
        return gson.fromJson(type, Source::class.java)
    }
}