package com.example.mvvmtesting.utils

sealed class ResponseData<out T>{
    object Loading: ResponseData<Nothing>()

    data class Success<out T>(val data: T? = null):ResponseData<T>()

    data class Error(val message: String? = null):ResponseData<Nothing>()
}
