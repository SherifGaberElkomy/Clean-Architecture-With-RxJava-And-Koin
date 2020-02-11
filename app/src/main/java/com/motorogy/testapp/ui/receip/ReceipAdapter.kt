package com.motorogy.testapp.ui.receip

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.R
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.databinding.ItemReceipBinding
import com.motorogy.testapp.domain.usecaes.GetAllReceipLocalUseCase
import com.motorogy.testapp.ui.BindingViewHolder
import com.motorogy.testapp.ui.callbackinterface.ICallBackClick
import com.motorogy.testapp.ui.callbackinterface.IRetreiveAllData
import com.motorogy.testapp.ui.receipdetails.ReceipDetailsActivity

class ReceipAdapter(var items: List<ReceipDoamainModel> = arrayListOf(), val vm: RecipViewModel) :
    RecyclerView.Adapter<ReceipAdapter.ReceipyViewHolder>() {

    private var mItemLocalInsert: GetAllReceipLocalUseCase= vm.mUseCaseItemLocal
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipyViewHolder {


        return ReceipyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_receip,
                parent,
                false
            ), mItemLocalInsert
        )
    }

    override fun onBindViewHolder(holder: ReceipyViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size
    class ReceipyViewHolder(view: View, itemLocalInsert: GetAllReceipLocalUseCase) : BindingViewHolder<ItemReceipBinding>(view),
        ICallBackClick,
        GetAllReceipLocalUseCase {
        override fun executeRetreiveAllDataLocally(callBkItemRetreiveAllData: IRetreiveAllData): List<ReceipEntity>? {
            return null
        }

        private var mItemInsertLocalData: GetAllReceipLocalUseCase = itemLocalInsert
        override fun executeSaveDataLocally(receipModel: ReceipDoamainModel) {
            mItemInsertLocalData.executeSaveDataLocally(receipModel)
        }


        override fun navigateItemToDetails(receipModel: ReceipDoamainModel) {
            var mIntent: Intent = Intent(
                AppClassApplication.mContext,
                ReceipDetailsActivity::class.java
            )
            mIntent.putExtra("recipItem", receipModel)
            AppClassApplication.mContext.startActivity(mIntent)
        }

        init {
            var mItemBinding: ItemReceipBinding = DataBindingUtil.bind<ItemReceipBinding>(view)!!
            mItemBinding.handlers = this
            mItemBinding.sv = this
        }

    }
}