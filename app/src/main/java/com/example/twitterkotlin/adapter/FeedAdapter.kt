package com.example.twitterkotlin.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterkotlin.R
import com.example.twitterkotlin.model.Post
import com.google.android.material.imageview.ShapeableImageView


/**
 * Created by Eldor Turgunov on 13.06.2022.
 * Twitter kotlin
 * eldorturgunov777@gmail.com
 */
class FeedAdapter(var context: Context, var items: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var feed = items[position]

        if (holder is FeedViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_post = holder.iv_post
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            iv_post.setVideoURI(Uri.parse("android.resource://" + context.packageName + "/" + feed.video))
            tv_fullname.text = feed.fullname
            holder.iv_post.setOnClickListener(View.OnClickListener { view: View? -> (holder as FeedViewHolder).iv_post.start() })
        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post: VideoView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.vv_video)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
}