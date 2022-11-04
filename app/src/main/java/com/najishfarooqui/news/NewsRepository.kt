package com.najishfarooqui.news

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewsRepository(
    private val newsApiService: NewsApiService,
    private val applicationContext: Context
) {
    private val newsLiveData = MutableLiveData<NewsResponseX>()
    val news: LiveData<NewsResponseX> get() = newsLiveData


    suspend fun getAllNews(){
        val result =newsApiService.getAllNews()
        if (result.code() ==200 && result.isSuccessful){
            if (result.body() != null){
                newsLiveData.postValue(result.body())
            }
        }
    }

}