package com.aralb.foodapplication.ui.categoryDetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aralb.foodapplication.databinding.FragmentCategoryDetailRowItemBinding
import com.aralb.foodapplication.model.food_detail_response.Meal
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CategoryDetailAdapter(
    private val context: Context,
    private val categoryDetailList: ArrayList<Meal>,
    val listener: CategoryToDetailClick
) : RecyclerView.Adapter<CategoryDetailAdapter.CategoryDetailViewHolder>() {

 inner class CategoryDetailViewHolder(private val binding: FragmentCategoryDetailRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun getBindCategoryDetail(detailBind: Meal) {
            binding.categoryDetailTextView.text = detailBind.strMeal
            Glide.with(binding.root)
                .load(detailBind.strMealThumb)
                .into(binding.categoryDetailImageView)
            binding.categoryDetailRow.setOnClickListener {
                listener.onClicked(detailBind)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailViewHolder {
        return CategoryDetailViewHolder(
            FragmentCategoryDetailRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryDetailViewHolder, position: Int) {
        val categoryDetailPosition = categoryDetailList[position]
        holder.getBindCategoryDetail(categoryDetailPosition)

    }

    override fun getItemCount(): Int = categoryDetailList.size

    fun update(mealList: List<Meal>) {
        categoryDetailList.clear()
        categoryDetailList.addAll(mealList)
        notifyDataSetChanged()
    }

    interface CategoryToDetailClick{
        fun onClicked(currentItem: Meal)
    }


}