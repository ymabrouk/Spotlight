package com.mindset.spots.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.mindset.spots.model.Article
import com.mindset.spots.service.api.ApiService
import io.reactivex.disposables.CompositeDisposable

class NewsDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: ApiService)
    : DataSource.Factory<Int, Article>() {

    val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()

    override fun create(): DataSource<Int, Article> {
        val newsDataSource = NewsDataSource(networkService, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}