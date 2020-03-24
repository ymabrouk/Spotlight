package com.mindset.spots.service.api

import com.mindset.spots.model.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headline")
    fun getRepo(@Query("q") search: String = "trending", @Query("sort") sort: String = "stars"): Call<ArticlesResponse>


    @GET("top-headlines")
    fun getTopHeadLine(@Query("language") search: String = "en", @Query("country") sort: String = "eg"): Call<ArticlesResponse>

}