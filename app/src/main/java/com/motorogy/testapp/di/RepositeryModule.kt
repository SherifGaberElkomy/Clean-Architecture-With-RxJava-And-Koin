package com.motorogy.testapp.di

import com.motorogy.testapp.data.repositeries.GetAllReceipImpl
import com.motorogy.testapp.data.repositeries.GetAllReceipLocalDataImpl
import com.motorogy.testapp.domain.repositeries.GetAllReceip
import com.motorogy.testapp.domain.repositeries.GetAllReceipLocalData
import org.koin.dsl.module.module

val repositoryModule = module(override = true) {
    factory<GetAllReceip> { GetAllReceipImpl(get()) }
    factory<GetAllReceipLocalData> { GetAllReceipLocalDataImpl()}
}