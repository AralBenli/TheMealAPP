package com.aralb.foodapplication.model.food_category_response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
    data class FoodCategoryResponse(
    @SerializedName(value = "categories")
    val categories: List<Category>
) : Parcelable