package com.example.twitterkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterkotlin.R
import com.example.twitterkotlin.adapter.FeedAdapter
import com.example.twitterkotlin.adapter.StoryAdapter
import com.example.twitterkotlin.model.Post
import com.example.twitterkotlin.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerStory: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerStory = findViewById<RecyclerView>(R.id.recyclerStory)
        recyclerStory.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerFeed = findViewById<RecyclerView>(R.id.recyclerFeed)
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshStoryAdapter(getAllStories())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshStoryAdapter(stories: ArrayList<Story>) {
        val adapter = StoryAdapter(this, stories)
        recyclerStory.adapter = adapter
    }

    fun refreshFeedAdapter(posts: ArrayList<Post>) {
        val adapter = FeedAdapter(this, posts)
        recyclerFeed.adapter = adapter
    }

    fun getAllStories(): ArrayList<Story> {
        val stories = ArrayList<Story>()
        stories.add(Story(R.drawable.im_user_1, "Xurshid"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_1, "Xurshid"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_1, "Xurshid"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        return stories
    }

    fun getAllFeeds(): ArrayList<Post> {
        val posts = ArrayList<Post>()
        posts.add(Post(R.drawable.im_user_1, "Xurshidbek Kurbanov", R.raw.vid))
        posts.add(Post(R.drawable.im_user_2, "Xurshidbek Kurbanov", R.raw.vid))
        posts.add(Post(R.drawable.im_user_3, "Xurshidbek Kurbanov", R.raw.vid))
        posts.add(Post(R.drawable.im_user_1, "Xurshidbek Kurbanov", R.raw.vid))
        posts.add(Post(R.drawable.im_user_2, "Xurshidbek Kurbanov", R.raw.vid))
        posts.add(Post(R.drawable.im_user_3, "Xurshidbek Kurbanov", R.raw.vid))
        return posts
    }
}