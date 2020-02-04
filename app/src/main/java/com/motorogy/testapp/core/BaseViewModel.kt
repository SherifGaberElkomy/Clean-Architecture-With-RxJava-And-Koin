package com.motorogy.testapp.core

import android.content.Context
import androidx.lifecycle.ViewModel
import com.motorogy.testapp.AppClassApplication
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    fun addToDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun getApplicationContext(): Context{
        return AppClassApplication.mContext
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

}