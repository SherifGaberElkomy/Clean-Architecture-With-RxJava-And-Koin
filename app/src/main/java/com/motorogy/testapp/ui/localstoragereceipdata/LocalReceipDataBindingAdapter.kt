package com.motorogy.testapp.ui.localstoragereceipdata

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import com.motorogy.testapp.ui.receip.ReceipAdapter
import com.motorogy.testapp.ui.receip.RecipViewModel

@BindingAdapter(value = ["receipslocal", "viewModel"])
fun setReceipLocal(view: RecyclerView, items: List<ReceipEntity>, vm: LocalReceipDataViewModel) {
    view.adapter?.run {
        if (this is LocalReceipDataAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        LocalReceipDataAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter("bind:imgUrl")
fun setImgItemPicture(imageView: ImageView, imgUrl: String ){
    Glide.with(imageView.getContext()).load("https://spoonacular.com/recipeImages/" + imgUrl).into(imageView)
}