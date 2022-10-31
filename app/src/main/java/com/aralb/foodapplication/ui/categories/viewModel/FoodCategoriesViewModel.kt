package com.aralb.foodapplication.ui.categories.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodCategoriesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _categoryData: MutableStateFlow<UIState<FoodCategoryResponse>> = MutableStateFlow(UIState.Loading())
    val categoryData = _categoryData.asStateFlow()

    fun getCategoryData() {
        viewModelScope.launch {
            repository.getFoodCategories().collectLatest {
                _categoryData.value = it

            }
        }
    }
}

