package com.aralb.foodapplication.ui.search.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.aralb.foodapplication.R
import com.aralb.foodapplication.databinding.FragmentFoodSearchBinding
import com.aralb.foodapplication.model.detail_response.DetailMealResponse
import com.aralb.foodapplication.ui.base.BaseFragment
import com.aralb.foodapplication.ui.search.adapter.SearchAdapter
import com.aralb.foodapplication.ui.search.viewModel.FoodSearchViewModel
<<<<<<< HEAD
=======
import com.aralb.foodapplication.util.DetailState
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodSearchFragment :
    BaseFragment<FragmentFoodSearchBinding>(FragmentFoodSearchBinding::inflate),
    SearchAdapter.OnClickedSearchToDetail {

    private val searchViewModel: FoodSearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var text: String

    override fun observer() {

        searchAdapter = SearchAdapter(requireContext(), arrayListOf(), this)
        binding.searchRecyclerView.adapter = searchAdapter

        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    text = query
                    searchViewModel.getSearch(f = text)
                    return true
                }
                return false
            }
        })
<<<<<<< HEAD


        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    searchViewModel.searchData.collectLatest { data ->
                        data.searchResponse?.let {
                            searchAdapter.update(it.detailMealResponses)
=======
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    searchViewModel.searchData.collectLatest { searchState ->
                        when (searchState) {
                            is DetailState.Error -> print(searchState.msg)
                            is DetailState.Loading ->
                                if (searchState.loading) {
                                    showLoadingProgress()
                                } else {
                                    dismissLoadingProgress()
                                }
                            is DetailState.Success -> searchState.data.let {
                                searchAdapter.update(it.detailMealResponses)
                            }
                            null -> {}
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
                        }
                    }
                }
            }
        }
    }

<<<<<<< HEAD

    override fun onClickedSearchToDetail(currentItem: DetailMealResponse) {
        val bundle = Bundle()
        bundle.putString("idMeal", currentItem.idMeal)
        findNavController().navigate(R.id.searchToDetail , bundle)
=======
    override fun onClickedSearchToDetail(currentItem: DetailMealResponse) {
        val bundle = Bundle()
        bundle.putString("idMeal", currentItem.idMeal)
        findNavController().navigate(R.id.searchToDetail, bundle)
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
    }


}