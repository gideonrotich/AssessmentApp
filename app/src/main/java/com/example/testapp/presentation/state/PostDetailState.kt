package com.example.testapp.presentation.state

import com.example.testapp.domain.model.Post

data class PostDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val post: Post? = null,
)
