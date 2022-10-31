package com.aralb.foodapplication.ui.detail.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.aralb.foodapplication.UIState
import com.aralb.foodapplication.databinding.FragmentDetailBinding
import com.aralb.foodapplication.ui.base.BaseFragment
import com.aralb.foodapplication.ui.detail.viewModel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val detailViewModel: DetailViewModel by viewModels()
    private var detailMeal: String? = null

    override fun observer() {

        detailMeal = requireArguments().getString("idMeal")
        detailMeal?.let {
            detailViewModel.getFoodDetails(it)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    detailViewModel.detailData.collectLatest { detailState ->
                        when (detailState) {
                            is UIState.Error -> print(detailState.msg)
                            is UIState.Loading ->
                                if (detailState.loading) {
                                    showLoadingProgress()
                                } else {
                                    dismissLoadingProgress()
                                }
                            is UIState.Success -> detailState.data.let {
                                binding.setData = it
                            }
                        }
                    }
                }
            }
        }
    }
}