package com.najishfarooqui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(val repository: NewsRepository) : ViewModel() {
    val newsLiveData get() = repository.news


    fun getAllNews() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getAllNews()
            }


        }
    }
}