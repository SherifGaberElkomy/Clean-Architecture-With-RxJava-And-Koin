package com.motorogy.testapp

import android.app.Application
import android.content.Context
import com.motorogy.testapp.di.*
import org.koin.android.ext.android.startKoin

class AppClassApplication : Application() {

    companion object{
        lateinit var mContext: Context
    }

    override fun onCreate() {
        super.onCreate()

        mContext = applicationContext
        startKoin(this, listOf(
            networkModule,
            apiModule,
            roomModule,
            repositoryModule,
            useCasesModule,
            viewModelModule
        ))
    }
}