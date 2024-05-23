package com.example.testapp.data.repository

import com.example.testapp.data.PostApi
import com.example.testapp.domain.model.Post
import com.example.testapp.domain.repository.PostRepository
import com.example.testapp.util.Resource
import com.example.testapp.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
):PostRepository {
    override suspend fun getPost(): Resource<List<Post>> {
        return safeApiCall(Dispatchers.IO) {
            api.getAllPosts()
        }
    }

    override suspend fun getPostDetail(id: String): Resource<Post> {
        return safeApiCall(Dispatchers.IO) {
            api.getPostById(postId = id)
        }
    }

}