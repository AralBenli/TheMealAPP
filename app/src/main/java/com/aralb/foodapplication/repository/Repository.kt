package com.aralb.foodapplication.repository

<<<<<<< HEAD
<<<<<<< HEAD
import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.aralb.foodapplication.network.FoodService
import com.aralb.foodapplication.util.CategoryState
=======
import com.aralb.foodapplication.network.FoodService
import com.aralb.foodapplication.util.DetailState
import com.aralb.foodapplication.util.FoodCategoryState
import com.aralb.foodapplication.util.FoodDetailState
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
=======
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.aralb.foodapplication.network.FoodService
>>>>>>> 3beae78a4058398eb524a4508a6c2bfbe7efa6a3
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: FoodService) {

<<<<<<< HEAD
<<<<<<< HEAD
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

    suspend fun getSearch(f: String): Flow<CategoryState<DetailResponse>> = flow {
        emit(CategoryState.Loading())
        try {
            val searchFoodData = apiService.getSearch(f)
            emit(CategoryState.Success(searchFoodData))
        } catch (ex: Exception) {
            emit(CategoryState.Error(ex.message.toString()))

=======
    suspend fun getFoodCategories(): Flow<FoodCategoryState> = flow {
        emit(FoodCategoryState.Loading(loading = true))
=======
    suspend fun getFoodCategories(): Flow<UIState<FoodCategoryResponse>> = flow {
        emit(UIState.Loading(true))
>>>>>>> 3beae78a4058398eb524a4508a6c2bfbe7efa6a3
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

    suspend fun getSearch(f: String): Flow<UIState<DetailResponse>> = flow {
        emit(UIState.Loading(loading = true))
        try {
            val searchFoodData = apiService.getSearch(f)
            emit(UIState.Success(searchFoodData))
            emit(UIState.Loading(loading = false))
        } catch (ex: Exception) {
<<<<<<< HEAD
            emit(DetailState.Error(ex.message.toString()))
            emit(DetailState.Loading(loading = false))
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
=======
            emit(UIState.Error(ex.message.toString()))
            emit(UIState.Loading(loading = false))
>>>>>>> 3beae78a4058398eb524a4508a6c2bfbe7efa6a3
        }
    }.flowOn(Dispatchers.IO)

}