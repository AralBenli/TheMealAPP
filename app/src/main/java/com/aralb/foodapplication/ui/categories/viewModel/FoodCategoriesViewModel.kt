package com.aralb.foodapplication.ui.categories.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.model.food_category_response.Category
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.repository.Repository
import com.aralb.foodapplication.util.CategoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodCategoriesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _categoryData: MutableStateFlow<UiState> =
        MutableStateFlow(UiState(isLoading = false))
    val categoryData = _categoryData.asStateFlow()

    fun getCategoryData() {
        viewModelScope.launch {
            repository.getFoodCategories().collect { uiState ->
                when (uiState) {
                    is CategoryState.Success -> {
                        _categoryData.update { successState ->
                            successState.copy(foodCategoryResponse = uiState.data, isLoading = false)
                        }
                    }
                    is CategoryState.Error -> {
                        _categoryData.update { errorState ->
                            errorState.copy(error = uiState.msg , isLoading = false)
                        }
                    }
                    is CategoryState.Loading -> {
                        _categoryData.update { loadingState ->
                            loadingState.copy(isLoading = true)
                        }
                    }
                }
            }
        }
    }

    data class UiState(
        val foodCategoryResponse: FoodCategoryResponse? = null,
        val isLoading: Boolean? = false,
        val error: String? = null
    )
}