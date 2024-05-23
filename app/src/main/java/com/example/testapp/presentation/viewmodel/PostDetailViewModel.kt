package com.example.testapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.repository.PostRepository
import com.example.testapp.presentation.state.PostDetailState
import com.example.testapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: PostRepository
) :ViewModel(){

    private val _postDetail = mutableStateOf(PostDetailState(isLoading = true))
    val postDetail: State<PostDetailState> = _postDetail

    val id = savedStateHandle.get<String>(key = "id") ?: ""

    fun getPostDetail() {
        viewModelScope.launch {
            when (val result = repository.getPostDetail(id = id)) {
                is Resource.Error -> {
                    _postDetail.value = PostDetailState(isLoading = false, error = result.message)
                }

                is Resource.Success -> {
                    _postDetail.value =
                        PostDetailState(isLoading = false, post = result.data ?: null)
                }

                else -> {
                    postDetail
                }
            }
        }
    }
}