package com.aralb.foodapplication.ui.categoryDetail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.aralb.foodapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodCategoryDetailViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _foodCategoryDetailData: MutableStateFlow<UIState<FoodDetailResponse?>> = MutableStateFlow(UIState.Loading())
    val foodCategoryDetailData = _foodCategoryDetailData.asStateFlow()


    fun getFoodCategoryDetailData(c: String?) {
        viewModelScope.launch {
            repository.getFoodCategoryDetails(c.toString()).collectLatest {
                _foodCategoryDetailData.value = it
            }
        }
    }
}
