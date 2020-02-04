package com.motorogy.testapp.di

import com.motorogy.testapp.data.remote.api.ReceipAPI
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(ReceipAPI::class.java) }
}