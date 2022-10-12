package com.aralb.foodapplication.repository

import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.network.FoodService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: FoodService) {

    suspend fun getFoodCategories(): Flow<FoodCategoryResponse> = flow {
        emit(apiService.getFoodCategories())
    }.flowOn(Dispatchers.IO)




}