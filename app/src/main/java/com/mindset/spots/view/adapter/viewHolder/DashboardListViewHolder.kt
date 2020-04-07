package com.mindset.spots.view.adapter.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.mindset.spots.R
import com.mindset.spots.model.Article
import kotlinx.android.synthetic.main.article_item.view.*


class DashboardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(itemData: Article?) {
        if (itemData != null) {
            itemView.title_tv.text = itemData.title
            itemView.publishedAt_tv.text =   itemData.source?.name
            itemView.source_tv.text =itemData.author

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
        }
    }

    companion object {
        fun create(parent: ViewGroup): DashboardListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)
            return DashboardListViewHolder(view)
        }
    }
}