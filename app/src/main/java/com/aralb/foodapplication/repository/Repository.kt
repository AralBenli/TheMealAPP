package com.aralb.foodapplication.repository


import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.aralb.foodapplication.network.FoodService
import com.aralb.foodapplication.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: FoodService) {
    suspend fun getFoodCategories(): Flow<UIState<FoodCategoryResponse>> = flow {
        emit(UIState.Loading(true))

        try {
            val categoryData = apiService.getFoodCategories()
            emit(UIState.Success(categoryData))
            emit(UIState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(UIState.Error(ex.message.toString()))
            emit(UIState.Loading(loading = false))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getFoodCategoryDetails(c: String): Flow<UIState<FoodDetailResponse>> = flow {
        emit(UIState.Loading(loading = true))
        try {
            val detailData = apiService.getFoodCategoryDetails(c)
            emit(UIState.Success(detailData))
            emit(UIState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(UIState.Error(ex.message.toString()))
            emit(UIState.Loading(loading = false))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetails(i: String): Flow<UIState<DetailResponse>> = flow {
        emit(UIState.Loading(loading = true))
        try {
            val specificDetailData = apiService.getFoodDetails(i)
            emit(UIState.Success(specificDetailData))
            emit(UIState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(UIState.Error(ex.message.toString()))
            emit(UIState.Loading(loading = false))

        }
    }.flowOn(Dispatchers.IO)

    suspend fun getSearch(s: String): Flow<UIState<DetailResponse>> = flow {
        emit(UIState.Loading(loading = true))
        try {
            val searchFoodData = apiService.getSearch(s)
            emit(UIState.Success(searchFoodData))
            emit(UIState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(UIState.Error(ex.message.toString()))
            emit(UIState.Loading(loading = false))
        }
    }.flowOn(Dispatchers.IO)
}