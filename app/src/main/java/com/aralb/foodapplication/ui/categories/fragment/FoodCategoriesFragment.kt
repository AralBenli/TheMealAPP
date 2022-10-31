package com.aralb.foodapplication.ui.categories.fragment

import android.os.Bundle
<<<<<<< HEAD
import androidx.core.view.isGone
import androidx.core.view.isVisible
=======
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
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
import com.aralb.foodapplication.util.FoodCategoryState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodCategoriesFragment :
    BaseFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate),
    FoodCategoryAdapter.RecyclerViewClickInterface {

    private lateinit var foodCategoryAdapter: FoodCategoryAdapter
    private val categoryViewModel: FoodCategoriesViewModel by viewModels()

    override fun observer() {

<<<<<<< HEAD
        binding.mainSearchView.setOnClickListener{
=======
        binding.mainSearchView.setOnClickListener {
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
            findNavController().navigate(R.id.mainToSearch)
        }

        foodCategoryAdapter = FoodCategoryAdapter(
<<<<<<< HEAD
=======
            requireContext(),
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
            foodCategories = arrayListOf(),
            this
        )

        binding.mainCategoryRecyclerView.adapter = foodCategoryAdapter

        categoryViewModel.getCategoryData()

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
<<<<<<< HEAD
                    categoryViewModel.categoryData.collect { data ->
                        if (data.isLoading == true) {
                            showLoadingProgress()
                        } else {
                            dismissLoadingProgress()
                        }
                        data.foodCategoryResponse?.let {
                            foodCategoryAdapter.update(it.categories)
                        }
=======
                    categoryViewModel.categoryData.collectLatest { mealState ->

                        when(mealState){
                            is FoodCategoryState.Error ->
                                print(mealState.msg)
                            is FoodCategoryState.Loading ->
                                if(mealState.loading){
                                    showLoadingProgress()
                                }else{
                                    dismissLoadingProgress()
                                }
                            is FoodCategoryState.Success ->
                                foodCategoryAdapter.update(mealState.data.categories)
                            else -> {}
                        }
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6

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

<<<<<<< HEAD

}
=======
    }
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6


