package com.aralb.foodapplication.ui.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aralb.foodapplication.databinding.FragmentCategoryRowItemBinding
import com.aralb.foodapplication.model.food_category_response.Category
import com.bumptech.glide.Glide


class FoodCategoryAdapter(
    private val foodCategories: ArrayList<Category> = arrayListOf(),
    private val listener: RecyclerViewClickInterface
) : RecyclerView.Adapter<FoodCategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: FragmentCategoryRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun getBind(categoryBind: Category) {

            binding.fragmentCategoryName.text = categoryBind.categoryName
            binding.fragmentCategoryOverview.text = categoryBind.overview
            Glide.with(binding.root)
                .load(categoryBind.url)
                .into(binding.fragmentCategoryImageView)

//            Picasso.get()
//                .load(categoryBind.url)
//                .into(binding.fragmentCategoryImageView)

            binding.fragmentCategoryName.setOnClickListener {
                listener.onItemClicked(categoryBind)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        return CategoryViewHolder(
            FragmentCategoryRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryPosition = foodCategories[position]
        holder.getBind(categoryPosition)
    }

    fun update(food: List<Category>) {
        foodCategories.clear()
        foodCategories.addAll(food)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = foodCategories.size
    interface RecyclerViewClickInterface {
        fun onItemClicked(currentItem: Category)
    }



}









