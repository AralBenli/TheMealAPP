package com.aralb.foodapplication.model.food_detail_response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodDetailResponse(
    @SerializedName(value = "meals")
    val meals: List<Meal>
):Parcelable