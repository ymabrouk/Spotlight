package com.mindset.spots.model

import android.text.format.DateUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.mindset.spots.R
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class Article{

        var author: String  = ""
        var title: String  = ""
        var description: String  = ""
        var source: Source? = null
        var publishedAt: String? = ""
        var url: String  = ""
        var urlToImage: String? = ""
        var content: Boolean  = true




        companion object {
//                @JvmStatic
//                @BindingAdapter("urlToImage")
//                fun loadImage(view: ImageView, urlToImage: String?) {
//                        if (!urlToImage.isNullOrEmpty()) {
//
//                                val circularProgressDrawable = CircularProgressDrawable(view.context)
//                                circularProgressDrawable.strokeWidth = 5f
//                                circularProgressDrawable.centerRadius = 30f
//                                circularProgressDrawable.arrowEnabled = true
//                                circularProgressDrawable.setColorSchemeColors(R.color.colorAccent)
//                                circularProgressDrawable.start()
//
//                                Glide.with(view.context)
//                                        .load(urlToImage)
//                                        .placeholder(circularProgressDrawable)
//                                        .into(view)
//                        }
//                }





//
//                @JvmStatic
//                @BindingAdapter("publishedAt")
//                fun publishedTimeAgo(view: TextView, publishedAt: String) {
////                        if (!publishedAt.isNullOrEmpty()) {
////                                view.setText(formatPubDate(publishedAt))
////                        }
////                        view.setText(formatPubDate(publishedAt))
//                }
//                private fun formatPubDate(pubDate: String): String {
////                           1985-03-04T12:34:56Z
////                        2020-04-04T00:17:04Z ==: yyyy-MM-dd'T'HH:mm:ssssss'Z'
////                        2020-04-03T22:53:16.79099Z
////                        2020-04-03T22:38:00.712168Z
////                        2020-04-03T22:38:00.712168Z
////                        val inputFormat =
////                                SimpleDateFormat("YYYY-MM-DDThh:mm:ss.sTZD")
////
//
//                        try {
//                                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'")
//                                val date = inputFormat.parse(pubDate)
//                                print(TimeAgo.using(date.time))
//                                return TimeAgo.using(date.time)
//                        }
//                        catch (e: Exception) {
//                                // handler
//                                return pubDate;
//                        }
//                        finally {
//                                // optional finally block
//                        }
//
//                        return ""
//                }
//
        }
}
