package com.aralb.foodapplication.model.food_category_response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    @SerializedName(value = "idCategory")
    val id: String,
    @SerializedName(value = "strCategory")
    val categoryName: String,
    @SerializedName(value = "strCategoryDescription")
    val overview: String,
    @SerializedName(value = "strCategoryThumb")
    val url: String
) : Parcelable