package com.mindset.spots.service.api

import com.mindset.spots.model.ArticlesResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headline")
    fun getRepo(@Query("q") search: String = "trending", @Query("sort") sort: String = "stars"): Call<ArticlesResponse>


    @GET("top-headlines")
    fun getTopHeadLine(@Query("language") search: String = "en"): Call<ArticlesResponse>


    @GET("top-headlines")
    fun getAllNews(@Query("page") page: Int, @Query("pageSize") pageSize: Int,  @Query("language") sort: String = "en"): Single<ArticlesResponse>

}