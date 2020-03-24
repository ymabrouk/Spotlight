package com.mindset.spots.view.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mindset.spots.BR
import com.mindset.spots.model.Article
import org.jetbrains.anko.sdk27.coroutines.onClick

class NewsListViewHolder constructor(private val dataBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: Article) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        itemView.onClick {
//            val bundle = bundleOf("url" to itemData.html_url)
//            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)

        }
    }
}