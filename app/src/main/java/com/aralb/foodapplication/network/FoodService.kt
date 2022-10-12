package com.aralb.foodapplication.network

import com.aralb.foodapplication.model.food_categories_detail_response.FoodCategoriesDetailResponse
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodService {

    @GET("categories.php")
    suspend fun getFoodCategories(): FoodCategoryResponse

    @GET("filter.php/{c}")
    suspend fun getFoodCategoryDetails(
        @Path("c") c: String
    ): FoodCategoriesDetailResponse


    @GET("lookup.php/{i}")
    suspend fun getFooDdDetails(
        @Path("i") i: Int
    ): FoodDetailResponse


}
