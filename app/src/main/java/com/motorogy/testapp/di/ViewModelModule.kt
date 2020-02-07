package com.motorogy.testapp.di

import com.motorogy.testapp.ui.localstoragereceipdata.LocalReceipDataViewModel
import com.motorogy.testapp.ui.receip.RecipViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { RecipViewModel(get(), get())}
    viewModel{ LocalReceipDataViewModel(get())}
}