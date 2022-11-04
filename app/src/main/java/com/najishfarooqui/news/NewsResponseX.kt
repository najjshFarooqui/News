package com.najishfarooqui.news

data class NewsResponseX(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)