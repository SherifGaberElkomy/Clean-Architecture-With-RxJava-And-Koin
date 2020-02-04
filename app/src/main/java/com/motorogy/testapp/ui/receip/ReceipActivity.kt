package com.motorogy.testapp.ui.receip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.annotation.LayoutRes
import com.motorogy.testapp.R
import com.motorogy.testapp.databinding.ActivityReceipBinding
import com.motorogy.testapp.ui.BaseViewActivity
import com.motorogy.testapp.ui.localstoragereceipdata.LocalDataActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ReceipActivity: BaseViewActivity<ActivityReceipBinding>() {

    lateinit var mBtn: Button
    companion object{
       lateinit var mActivityRunThread: ReceipActivity
    }

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_receip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadControl()
        mActivityRunThread = this@ReceipActivity

        try {
            binding.vm = getViewModel()
            binding.setLifecycleOwner(this)
            var mReceipViewModel: RecipViewModel = binding.vm as RecipViewModel
            mReceipViewModel.doSearch()
        }catch (e: Exception){
            e.message?.let {
                var mError: String = it
            }
        }


        mBtn.setOnClickListener({
            startActivity(Intent(applicationContext, LocalDataActivity::class.java))
        })

    }

    private fun loadControl() {
        mBtn = findViewById(R.id.showLocalData)
    }
}