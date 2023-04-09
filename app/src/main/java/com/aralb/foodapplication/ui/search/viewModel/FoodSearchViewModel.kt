package com.aralb.foodapplication.ui.search.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.aralb.foodapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodSearchViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _searchData: MutableStateFlow<UIState<DetailResponse?>> =
        MutableStateFlow(UIState.Loading())
    val searchData = _searchData.asStateFlow()


    fun getSearch(f: String) {
        viewModelScope.launch {
            repository.getSearch(f).collectLatest {
                try {
                    if(it != null){
                    _searchData.value = it
                } }catch (e: Error) {
                    Log.d("SearchFragment", e.message.toString())
                }
            }
        }
    }
}



