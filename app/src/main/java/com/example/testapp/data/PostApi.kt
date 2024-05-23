package com.example.testapp.data

import com.example.testapp.domain.model.Post
import com.example.testapp.domain.model.PostResponseItem
import com.example.testapp.util.Resource
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("posts")
    suspend fun getAllPosts() : List<Post>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId: String): Post
}