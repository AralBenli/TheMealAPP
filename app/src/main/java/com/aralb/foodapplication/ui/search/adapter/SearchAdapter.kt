package com.aralb.foodapplication.ui.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aralb.foodapplication.databinding.SearchRowItemBinding
import com.aralb.foodapplication.model.detail_response.DetailMealResponse
import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SearchAdapter(
    private val context: Context,
    private val searchList: ArrayList<DetailMealResponse>,
    private val listener: OnClickedSearchToDetail
) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    inner class SearchViewHolder(private val binding: SearchRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun getBind(searchBind: DetailMealResponse) {
            binding.searchDetailTextView.text = searchBind.strMeal
            Glide.with(binding.root)
                .load(searchBind.strMealThumb)
                .apply(RequestOptions().override(1440, 1080))
                .into(binding.searchImageView)

            binding.searchRow.setOnClickListener {
                listener.onClickedSearchToDetail(searchBind)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            SearchRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val searchPosition = searchList[position]
        holder.getBind(searchPosition)
    }

    override fun getItemCount(): Int = searchList.size


    fun update(search: List<DetailMealResponse>?) {
        searchList.clear()
        search?.let { searchList.addAll(it) }
        notifyDataSetChanged()
    }


    interface OnClickedSearchToDetail {
        fun onClickedSearchToDetail(currentItem: DetailMealResponse)
    }


}