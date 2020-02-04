package com.motorogy.testapp.di

import com.motorogy.testapp.data.db.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {
      single { AppDataBase.invoke(androidApplication()) }
     single(createOnStart = false) { get<AppDataBase>().getReceipDao()}
}