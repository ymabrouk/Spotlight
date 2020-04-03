package com.mindset.spots.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindset.spots.model.Article
import com.mindset.spots.databinding.ArticleItemBindingImpl
import com.mindset.spots.view.adapter.viewHolder.NewsListViewHolder

class NewsListAdapter() : RecyclerView.Adapter<NewsListViewHolder>() {
    var articlesList: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ArticleItemBindingImpl.inflate(inflater, parent, false)
        return NewsListViewHolder(dataBinding)
    }

    override fun getItemCount() = articlesList.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.setup(articlesList[position])
    }

    fun updateRepoList(repoList: List<Article>) {
        this.articlesList = repoList
        notifyDataSetChanged()
    }
}