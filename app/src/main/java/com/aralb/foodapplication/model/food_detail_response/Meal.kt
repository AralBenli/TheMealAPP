package com.aralb.foodapplication.model.food_detail_response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idMeal: String,
    val strMealThumb: String,
    val strMeal: String,

    ): Parcelable