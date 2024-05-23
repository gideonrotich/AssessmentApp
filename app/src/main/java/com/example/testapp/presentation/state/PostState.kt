package com.example.testapp.presentation.state

import com.example.testapp.domain.model.Post

data class PostState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val posts: List<Post> = emptyList(),
)
