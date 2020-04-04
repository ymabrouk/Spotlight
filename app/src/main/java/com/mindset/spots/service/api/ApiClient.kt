package com.mindset.spots.service.api


import com.google.gson.GsonBuilder
import com.mindset.spots.R
import com.mindset.spots.application.SpotsApplication
import com.mindset.spots.view.util.Constants.Companion.BASE_URL
import com.mindset.spots.view.util.Constants.Companion.DEBUG
import com.mindset.spots.view.util.Constants.Companion.REQUEST_TIMEOUT_DURATION
import com.mindset.spots.view.util.Constants.Companion.apiKey
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    val instance: ApiService = Retrofit.Builder().run {
        val gson = GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create()

        baseUrl(BASE_URL)
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        addConverterFactory(GsonConverterFactory.create(gson))
        client(createRequestInterceptorClient())
        build()
    }.create(ApiService::class.java)


    private fun createRequestInterceptorClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val originalUrl = original.url()
            val url = originalUrl.newBuilder()
                .addQueryParameter(apiKey, SpotsApplication.instance.getString(R.string.api_key_id))
                .build()
            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
//            requestBuilder.addHeader("X-CMC_PRO_API_KEY", "CMC_PRO_API_KEY")
            chain.proceed(request)
        }

        return if (DEBUG) {
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .build()
        } else {
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .build()
        }
    }
}