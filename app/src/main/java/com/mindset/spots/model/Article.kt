package com.mindset.spots.model

data class Article(
        val author: String,
        val title: String,
        val description: String,
        val source: Source,
        val publishedAt: String,
        val urlToImage: String,
        val url: String,
        val content: Boolean
)

