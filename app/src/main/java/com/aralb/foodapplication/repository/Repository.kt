package com.aralb.foodapplication.repository

import com.aralb.foodapplication.network.FoodService
import com.aralb.foodapplication.util.DetailState
import com.aralb.foodapplication.util.FoodCategoryState
import com.aralb.foodapplication.util.FoodDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: FoodService) {

    suspend fun getFoodCategories(): Flow<FoodCategoryState> = flow {
        emit(FoodCategoryState.Loading(loading = true))
        try {
            val categoryData = apiService.getFoodCategories()
            emit(FoodCategoryState.Success(categoryData))
            emit(FoodCategoryState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(FoodCategoryState.Error(ex.message.toString()))
            emit(FoodCategoryState.Loading(loading = false))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getFoodCategoryDetails(c: String): Flow<FoodDetailState> = flow {
        emit(FoodDetailState.Loading(loading = true))
        try {
            val detailData = apiService.getFoodCategoryDetails(c)
            emit(FoodDetailState.Success(detailData))
            emit(FoodDetailState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(FoodDetailState.Error(ex.message.toString()))
            emit(FoodDetailState.Loading(loading = false))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetails(i: String): Flow<DetailState> = flow {
        emit(DetailState.Loading(loading = true))
        try {
            val specificDetailData = apiService.getFoodDetails(i)
            emit(DetailState.Success(specificDetailData))
            emit(DetailState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(DetailState.Error(ex.message.toString()))
            emit(DetailState.Loading(loading = false))

        }
    }.flowOn(Dispatchers.IO)

    suspend fun getSearch(f: String): Flow<DetailState> = flow {
        emit(DetailState.Loading(loading = true))
        try {
            val searchFoodData = apiService.getSearch(f)
            emit(DetailState.Success(searchFoodData))
            emit(DetailState.Loading(loading = false))
        } catch (ex: Exception) {
            emit(DetailState.Error(ex.message.toString()))
            emit(DetailState.Loading(loading = false))
        }
    }.flowOn(Dispatchers.IO)

}