package com.motorogy.testapp

import com.motorogy.testapp.data.remote.api.ReceipAPI
import org.koin.dsl.module.module

val testApiModule = module {
    single { ReceipAPI() as ReceipAPI }
}