package com.aralb.foodapplication.util

<<<<<<< HEAD
=======
import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
object Constants {

    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
}

<<<<<<< HEAD
<<<<<<< HEAD
sealed class CategoryState<out T>(val data: T? = null, val msg: String? = null) {
    class Success<T>(data: T) : CategoryState<T>(data)
    class Loading<T>(data: T? = null) : CategoryState<T>()
    class Error<T>(msg: String? = null) : CategoryState<T>(msg = msg)

}

=======
sealed class FoodCategoryState() {
    data class Success(val data: FoodCategoryResponse) : FoodCategoryState()
    data class Loading(val loading:Boolean = false): FoodCategoryState()
    data class Error(val msg: String? = null) : FoodCategoryState()
=======



fun glide(context: Context, url: String?, imageView: ImageView) {

    if (!url.isNullOrEmpty()) {
        Glide
            .with(context)
            .load(url)
            .into(imageView)

    }
>>>>>>> 3beae78a4058398eb524a4508a6c2bfbe7efa6a3
}

@BindingAdapter("app:imageUrl")
fun ImageView.setUrl(poster_path: String?) {
    if (poster_path != null)
        Glide.with(context)
            .load(poster_path)
            .apply(RequestOptions().override(1000, 400))
            .into(this)
}
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
