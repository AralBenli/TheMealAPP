package com.aralb.foodapplication.ui.categoryDetail.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.aralb.foodapplication.R
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.databinding.FragmentCategoryDetailBinding
import com.aralb.foodapplication.model.food_detail_response.Meal
import com.aralb.foodapplication.ui.base.BaseFragment
import com.aralb.foodapplication.ui.categoryDetail.adapter.CategoryDetailAdapter
import com.aralb.foodapplication.ui.categoryDetail.viewModel.FoodCategoryDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodCategoryDetailFragment :
    BaseFragment<FragmentCategoryDetailBinding>(FragmentCategoryDetailBinding::inflate),
    CategoryDetailAdapter.CategoryToDetailClick {
    private val categoryDetailViewModel: FoodCategoryDetailViewModel by viewModels()
    private lateinit var categoryDetailAdapter: CategoryDetailAdapter
    private var categoryDetail: String? = null

    override fun observer() {
        categoryDetail = requireArguments().getString("category")

        categoryDetailAdapter = CategoryDetailAdapter(
            requireContext(),
            arrayListOf(),
            this
        )
        binding.categoryDetailRecyclerView.adapter = categoryDetailAdapter

        categoryDetailViewModel.getFoodCategoryDetailData(categoryDetail)

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    categoryDetailViewModel.foodCategoryDetailData.collect { foodCategoryState ->
                        when (foodCategoryState) {
                            is UIState.Error -> print(foodCategoryState.msg)
                            is UIState.Loading ->
                                if (foodCategoryState.loading) {
                                    showLoadingProgress()
                                } else {
                                    dismissLoadingProgress()
                                }
                            is UIState.Success -> foodCategoryState.data?.let {
                                categoryDetailAdapter.update(
                                    foodCategoryState.data.meals
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onClicked(currentItem: Meal) {
        val bundle = Bundle()
        bundle.putString("idMeal", currentItem.idMeal)
        findNavController().navigate(R.id.CategoryToDetail, bundle)
    }
}