package com.example.testapp.util

sealed class UiEvents {
    data class SnackbarEvent(val message: String) : UiEvents()
}
