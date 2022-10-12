package com.aralb.foodapplication.model.food_categories_detail_response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class FoodCategoriesDetailResponse(
    @SerializedName(value = "page")
    val page: Int,
    @SerializedName(value = "results")
    val results: List<Result>,
    @SerializedName(value = " total_pages")
    val totalPages: Int,
    @SerializedName(value = "total_results")
    val totalResults: Int
) : Parcelable