package com.aralb.foodapplication.util


import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
object Constants {

    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
}


fun glide(context: Context, url: String?, imageView: ImageView) {

    if (!url.isNullOrEmpty()) {
        Glide
            .with(context)
            .load(url)
            .into(imageView)

    }
}

@BindingAdapter("app:imageUrl")
fun ImageView.setUrl(poster_path: String?) {
    if (poster_path != null)
        Glide.with(context)
            .load(poster_path)
            .apply(RequestOptions().override(280, 250))
            .into(this)
}
