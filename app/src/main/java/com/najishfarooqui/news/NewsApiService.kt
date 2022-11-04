package com.najishfarooqui.news

import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {


    @GET("top-headlines?country=us&apiKey=3ea98f640b7f43f9a53dc16069e1d6e1")
    suspend fun getAllNews(): Response<NewsResponseX>
}