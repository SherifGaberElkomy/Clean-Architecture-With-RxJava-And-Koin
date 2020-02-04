package com.motorogy.testapp.ui.receip

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel


@BindingAdapter(value = ["receips", "viewModel"])
fun setReceip(view: RecyclerView, items: List<ReceipDoamainModel>, vm: RecipViewModel) {
    view.adapter?.run {
        if (this is ReceipAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        ReceipAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter("bind:imgUrl")
fun setImgItemPicture(imageView: ImageView, imgUrl: String ){
    Glide.with(imageView.getContext()).load("https://spoonacular.com/recipeImages/" + imgUrl).into(imageView)
}
