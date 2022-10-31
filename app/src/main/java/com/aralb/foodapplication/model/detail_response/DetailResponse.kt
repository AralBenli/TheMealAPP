package com.aralb.foodapplication.model.detail_response

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName(value ="meals")
    val detailMealResponses: List<DetailMealResponse> ,
)