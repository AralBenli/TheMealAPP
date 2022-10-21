package com.aralb.foodapplication.ui.categories.fragment

import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.aralb.foodapplication.R
import com.aralb.foodapplication.databinding.FragmentCategoriesBinding
import com.aralb.foodapplication.model.food_category_response.Category
import com.aralb.foodapplication.ui.categories.adapter.FoodCategoryAdapter
import com.aralb.foodapplication.ui.base.BaseFragment
import com.aralb.foodapplication.ui.categories.viewModel.FoodCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodCategoriesFragment :
    BaseFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate),
    FoodCategoryAdapter.RecyclerViewClickInterface {

    private lateinit var foodCategoryAdapter: FoodCategoryAdapter
    private val categoryViewModel: FoodCategoriesViewModel by viewModels()

    override fun observer() {

        binding.mainSearchView.setOnClickListener{
            findNavController().navigate(R.id.mainToSearch)
        }

        foodCategoryAdapter = FoodCategoryAdapter(
            foodCategories = arrayListOf(),
            this
        )

        binding.mainCategoryRecyclerView.adapter = foodCategoryAdapter

        categoryViewModel.getCategoryData()

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    categoryViewModel.categoryData.collect { data ->
                        if (data.isLoading == true) {
                            showLoadingProgress()
                        } else {
                            dismissLoadingProgress()
                        }
                        data.foodCategoryResponse?.let {
                            foodCategoryAdapter.update(it.categories)
                        }

                    }
                }
            }
        }
    }

    override fun onItemClicked(currentItem: Category) {
        val bundle = Bundle()
        bundle.putString("category", currentItem.categoryName)
        findNavController().navigate(R.id.mainToCategory, bundle)
    }


}


