package com.motorogy.testapp.ui.receip

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.motorogy.testapp.R
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import com.motorogy.testapp.databinding.ItemReceipBinding
import com.motorogy.testapp.ui.BindingViewHolder
import com.motorogy.testapp.ui.callbackinterface.ICallBackClick
import com.motorogy.testapp.ui.receipdetails.ReceipDetailsActivity

class ReceipAdapter(var items: List<ReceipDoamainModel> = arrayListOf(), val vm: RecipViewModel) :
    RecyclerView.Adapter<ReceipAdapter.ReceipyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipyViewHolder {
        return ReceipyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_receip,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReceipyViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size
    class ReceipyViewHolder(view: View) : BindingViewHolder<ItemReceipBinding>(view), ICallBackClick{
        override fun navigateItemToDetails(receipModel: ReceipDoamainModel) {
            var mIntent: Intent = Intent(ReceipActivity.mActivityRunThread.applicationContext, ReceipDetailsActivity::class.java)
            mIntent.putExtra("recipItem", receipModel)
            ReceipActivity.mActivityRunThread.startActivity(mIntent)
        }

        init {
            var mItemBinding: ItemReceipBinding = DataBindingUtil.bind<ItemReceipBinding>(view)!!
            mItemBinding.handlers = this
        }

    }
}