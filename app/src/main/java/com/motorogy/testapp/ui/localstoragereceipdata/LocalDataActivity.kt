package com.motorogy.testapp.ui.localstoragereceipdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.motorogy.testapp.R
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.databinding.ActivityLocalDataBinding
import com.motorogy.testapp.databinding.ActivityReceipBindingImpl
import com.motorogy.testapp.ui.BaseViewActivity
import com.motorogy.testapp.ui.receip.ReceipActivity
import com.motorogy.testapp.ui.receip.RecipViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LocalDataActivity : BaseViewActivity<ActivityLocalDataBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_local_data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            binding.vm = getViewModel()
            binding.setLifecycleOwner(this)
            var mReceipLocalViewModel: LocalReceipDataViewModel =
                binding.vm as LocalReceipDataViewModel
            mReceipLocalViewModel.getAllItems()
        } catch (e: Exception) {
            e.message?.let {
                var mError: String = it
            }
        }

    }
}



