package com.aralb.foodapplication.util

object Constants {

    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
}

sealed class CategoryState<out T>(val data: T? = null, val msg: String? = null) {
    class Success<T>(data: T) : CategoryState<T>(data)
    class Loading<T>(data: T? = null) : CategoryState<T>()
    class Error<T>(msg: String? = null) : CategoryState<T>(msg = msg)

}

