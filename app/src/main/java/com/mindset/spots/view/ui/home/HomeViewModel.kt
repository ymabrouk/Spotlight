package com.mindset.spots.view.ui.home

import androidx.lifecycle.MutableLiveData
import com.mindset.spots.model.Article
import com.mindset.spots.service.repository.FeedsRepository
import com.mindset.spots.view.base.BaseViewModel

class HomeViewModel : BaseViewModel() {



    val feedsListLive = MutableLiveData<List<Article>>()

    fun fetchRepoList() {
        dataLoading.value = true
        FeedsRepository.getInstance().getTendingNews { isSuccess, response ->

            dataLoading.value = false
            if (isSuccess) {
                feedsListLive.value = response?.articles
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }

}