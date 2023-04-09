package com.aralb.foodapplication.network

import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {

    @GET("categories.php")
    suspend fun getFoodCategories(): FoodCategoryResponse


    @GET("filter.php")
    suspend fun getFoodCategoryDetails(
        @Query("c") category: String
    ): FoodDetailResponse

    @GET("lookup.php")
    suspend fun getFoodDetails(@Query("i") id: String): DetailResponse


    @GET("search.php")
    suspend fun getSearch(@Query("s") s: String): DetailResponse

}

