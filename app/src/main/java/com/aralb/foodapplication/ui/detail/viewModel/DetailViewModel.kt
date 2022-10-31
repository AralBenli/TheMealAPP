package com.aralb.foodapplication.ui.detail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    private val _detailData: MutableStateFlow<UIState<DetailResponse>> = MutableStateFlow(UIState.Loading())
    val detailData = _detailData.asStateFlow()


    fun getFoodDetails(i: String) {
        viewModelScope.launch {
            repository.getDetails(i).collectLatest {
                _detailData.value = it
            }
        }
    }
}




