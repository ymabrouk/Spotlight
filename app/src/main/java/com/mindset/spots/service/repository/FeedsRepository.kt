package com.mindset.spots.service.repository

import com.mindset.spots.model.ArticlesResponse
import com.mindset.spots.service.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsRepository {

    fun getTendingNews(onResult: (isSuccess: Boolean, response: ArticlesResponse?) -> Unit) {

        ApiClient.instance.getTopHeadLine().enqueue(object : Callback<ArticlesResponse> {
            override fun onResponse(call: Call<ArticlesResponse>?, response: Response<ArticlesResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<ArticlesResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }


    companion object {
        private var INSTANCE: FeedsRepository? = null
        fun getInstance() = INSTANCE
            ?: FeedsRepository().also {
                INSTANCE = it
            }
    }

}