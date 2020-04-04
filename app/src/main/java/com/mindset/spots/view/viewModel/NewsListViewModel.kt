package com.mindset.spots.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mindset.spots.dataSource.NewsDataSource
import com.mindset.spots.dataSource.NewsDataSourceFactory
import com.mindset.spots.model.Article
import com.mindset.spots.model.State
import com.mindset.spots.service.api.ApiClient
import com.mindset.spots.service.api.ApiService
import io.reactivex.disposables.CompositeDisposable

class NewsListViewModel  : ViewModel() {

    private val networkService = ApiClient.instance
    var newsList: LiveData<PagedList<Article>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val newsDataSourceFactory: NewsDataSourceFactory

    init {
        newsDataSourceFactory = NewsDataSourceFactory(compositeDisposable, networkService)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder<Int, Article>(newsDataSourceFactory, config).build()
    }


    fun getState(): LiveData<State> = Transformations.switchMap<NewsDataSource,
            State>(newsDataSourceFactory.newsDataSourceLiveData, NewsDataSource::state)

    fun retry() {
        newsDataSourceFactory.newsDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return newsList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}