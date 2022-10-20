package com.aralb.foodapplication.repository

import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.detail_response.Meal
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.aralb.foodapplication.network.FoodService
import com.aralb.foodapplication.util.CategoryState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: FoodService) {

    suspend fun getFoodCategories(): Flow<CategoryState<FoodCategoryResponse>> = flow {
        emit(CategoryState.Loading())
        try {
            val data = apiService.getFoodCategories()
            emit(CategoryState.Success(data))
        } catch (ex: Exception) {
            emit(
                CategoryState.Error(ex.message.toString())
            )
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getFoodCategoryDetails(c: String): Flow<CategoryState<FoodDetailResponse>> = flow {
        emit(CategoryState.Loading())
        try {
            val detailData = apiService.getFoodCategoryDetails(c)
            emit(CategoryState.Success(detailData))
        } catch (ex: Exception) {
            emit(CategoryState.Error(ex.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetails(i: String): Flow<CategoryState<DetailResponse>> = flow {
        emit(CategoryState.Loading())
        try {
            val specificDetailData = apiService.getFoodDetails(i)
            emit(CategoryState.Success(specificDetailData))
        } catch (ex: Exception) {
            emit(CategoryState.Error(ex.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}