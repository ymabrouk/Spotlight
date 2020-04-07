package com.mindset.spots.view.adapter.viewHolder

import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.mindset.spots.BR
import com.mindset.spots.R
import com.mindset.spots.model.Article
import kotlinx.android.synthetic.main.article_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NewsListViewHolder constructor(private val dataBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: Article) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()


        if (!itemData.urlToImage.isNullOrEmpty()) {

            val circularProgressDrawable = CircularProgressDrawable(itemView.promotion_image.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.arrowEnabled = true
            circularProgressDrawable.setColorSchemeColors(R.color.colorAccent)
            circularProgressDrawable.start()

            Glide.with(itemView.promotion_image.context)
                .load(itemData.urlToImage)
                .placeholder(circularProgressDrawable)
                .into(itemView.promotion_image)
        }







        itemView.onClick {
//            val bundle = org.jetbrains.anko.bundleOf("url" to itemData.html_url)
//            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}