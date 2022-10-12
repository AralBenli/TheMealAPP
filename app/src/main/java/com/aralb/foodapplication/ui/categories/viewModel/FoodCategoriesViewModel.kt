package com.aralb.foodapplication.ui.categories.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val foodCategoryResponse: FoodCategoryResponse? = null

    private val _categoryData = MutableStateFlow(foodCategoryResponse)
    val categoryData = _categoryData.asStateFlow()


    fun getCategoryData() {
        viewModelScope.launch {
            repository.getFoodCategories().collectLatest { data ->
                _categoryData.value = data
            }
        }
    }

}