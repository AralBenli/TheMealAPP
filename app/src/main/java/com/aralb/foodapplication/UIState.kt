package com.aralb.foodapplication

sealed class UIState<out T> {
    data class Success<T>(val data: T) : UIState<T>()
    data class Loading(val loading: Boolean = false) : UIState<Nothing>()
    data class Error(val msg: String? = null) : UIState<Nothing>()
}