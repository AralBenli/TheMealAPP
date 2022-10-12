package com.aralb.foodapplication.ui.categories.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.aralb.foodapplication.ui.categories.adapter.FoodCategoryAdapter
import com.aralb.foodapplication.databinding.FragmentCategoriesBinding
import com.aralb.foodapplication.ui.base.BaseFragment
import com.aralb.foodapplication.ui.categories.viewModel.FoodCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodCategoriesFragment :
    BaseFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

    private lateinit var foodCategoryAdapter: FoodCategoryAdapter
    private val categoryViewModel: FoodCategoriesViewModel by viewModels()

    override fun observer() {
        foodCategoryAdapter = FoodCategoryAdapter()
        binding.mainCategoryRecyclerView.adapter = foodCategoryAdapter
        categoryViewModel.getCategoryData()

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    categoryViewModel.categoryData.collect { data ->
                        if (!data?.categories.isNullOrEmpty()) {
                            data?.let {
                                foodCategoryAdapter.update(data.categories)
                            }
                        }
                    }
                }
            }
        }
    }
}