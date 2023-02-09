package com.example.mvvmtesting.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtesting.data.api.dto.NewsResponseDto
import com.example.mvvmtesting.model.Article
import com.example.mvvmtesting.usecase.DataUseCase
import com.example.mvvmtesting.utils.ResponseData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val dataUseCase: DataUseCase):ViewModel() {

    private val dataListMutableLiveData: MutableLiveData<ResponseData<List<Article>>> =
        MutableLiveData()

    val dataListLiveData: LiveData<ResponseData<List<Article>>>
        get() = dataListMutableLiveData

    fun fetchArticles() {
        viewModelScope.launch (Dispatchers.IO) {
            dataUseCase.fetchArticles(language = "gb", category = "").collect{
                dataListMutableLiveData.postValue(it)
            }
        }
    }
}