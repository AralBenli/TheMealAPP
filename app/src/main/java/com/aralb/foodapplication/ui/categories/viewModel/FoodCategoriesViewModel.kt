package com.aralb.foodapplication.ui.categories.viewModel

<<<<<<< HEAD
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.model.food_category_response.Category
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.repository.Repository
import com.aralb.foodapplication.util.CategoryState
=======

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.repository.Repository
<<<<<<< HEAD
import com.aralb.foodapplication.util.FoodCategoryState
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
=======
>>>>>>> 3beae78a4058398eb524a4508a6c2bfbe7efa6a3
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

<<<<<<< HEAD
<<<<<<< HEAD
    private val _categoryData: MutableStateFlow<UiState> =
        MutableStateFlow(UiState(isLoading = false))
=======


    private val _categoryData: MutableStateFlow<FoodCategoryState?> = MutableStateFlow(null)
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
=======
    private val _categoryData: MutableStateFlow<UIState<FoodCategoryResponse>> = MutableStateFlow(UIState.Loading())
>>>>>>> 3beae78a4058398eb524a4508a6c2bfbe7efa6a3
    val categoryData = _categoryData.asStateFlow()

    fun getCategoryData() {
        viewModelScope.launch {
<<<<<<< HEAD
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
=======
            repository.getFoodCategories().collectLatest {
                _categoryData.value = it

>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
            }
        }
    }
}

<<<<<<< HEAD
    data class UiState(
        val foodCategoryResponse: FoodCategoryResponse? = null,
        val isLoading: Boolean? = false,
        val error: String? = null
    )
}
=======
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
