package com.example.testapp.domain.repository

import com.example.testapp.domain.model.Post
import com.example.testapp.util.Resource

interface PostRepository {
    suspend fun getPost(): Resource<List<Post>>

    suspend fun getPostDetail(id: String):Resource<Post>
}