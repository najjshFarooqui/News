package com.najishfarooqui.news

import android.app.Application

class NewsApplication  : Application(){
    lateinit var newsRepository: NewsRepository

    override fun onCreate() {
        super.onCreate()
        initialize()

    }
    private fun initialize(){
        val quoteService = RetrofitHelper.getInstance().create(NewsApiService::class.java)

        newsRepository = NewsRepository(quoteService, applicationContext)
    }
}