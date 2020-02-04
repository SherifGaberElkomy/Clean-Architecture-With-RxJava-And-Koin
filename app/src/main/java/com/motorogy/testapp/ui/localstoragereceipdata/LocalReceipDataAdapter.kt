package com.motorogy.testapp.ui.localstoragereceipdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.motorogy.testapp.R
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import com.motorogy.testapp.databinding.ItemReceipBinding
import com.motorogy.testapp.databinding.LocalReceipdataitemBinding
import com.motorogy.testapp.ui.BindingViewHolder
import com.motorogy.testapp.ui.receip.ReceipAdapter
import com.motorogy.testapp.ui.receip.RecipViewModel

class LocalReceipDataAdapter(var items: List<ReceipEntity> = arrayListOf(), val vm: LocalReceipDataViewModel) :
    RecyclerView.Adapter<LocalReceipDataAdapter.ReceipyLocalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipyLocalViewHolder {
        return ReceipyLocalViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.local_receipdataitem,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReceipyLocalViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size
    class ReceipyLocalViewHolder(view: View) : BindingViewHolder<LocalReceipdataitemBinding>(view)
}