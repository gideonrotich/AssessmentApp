package com.example.testapp.data.mapper

import com.example.testapp.domain.model.Post
import com.example.testapp.domain.model.PostResponse

internal fun PostResponse.toPost():Post{
    return Post(body, id, title, userId)
}