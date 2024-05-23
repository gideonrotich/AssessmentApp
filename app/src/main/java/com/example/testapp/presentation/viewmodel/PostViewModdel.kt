package com.example.testapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.repository.PostRepository
import com.example.testapp.presentation.state.PostState
import com.example.testapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModdel @Inject constructor(
    private val repository: PostRepository
):ViewModel(){

    private val _post = mutableStateOf(PostState(isLoading = true))
    val post: State<PostState> = _post

    init {
        getPost()
    }

    fun getPost() {
        viewModelScope.launch {
            when (val result = repository.getPost()) {
                is Resource.Error -> {
                    _post.value = PostState(isLoading = false, error = result.message)
                }

                is Resource.Success -> {
                    _post.value = PostState(isLoading = false, posts = result.data ?: ArrayList())
                }

                else -> {
                    post
                }
            }
        }
    }
}