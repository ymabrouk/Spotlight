package com.mindset.spots.model

data class ArticlesResponse(
        val totalResults: Int,
        val status: String,
        val articles: List<Article>
)
