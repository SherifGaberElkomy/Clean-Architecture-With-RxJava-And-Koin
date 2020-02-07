package com.motorogy.testapp.ui.localstoragereceipdata

import android.os.AsyncTask
import android.os.Handler
import android.widget.Toast
import com.motorogy.testapp.core.BaseViewModel
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.dao.ReceipDao
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.repositeries.GetAllReceipLocalDataImpl
import com.motorogy.testapp.domain.usecaes.GetAllReceipLocalUseCase
import com.motorogy.testapp.ui.callbackinterface.IRetreiveAllData
import com.motorogy.testapp.util.NotNullMutableLiveData

class LocalReceipDataViewModel(private val useCaseItemLocal: GetAllReceipLocalUseCase) :
    BaseViewModel(), IRetreiveAllData {
    override fun retreiveAllData(items: List<ReceipEntity>?) {
        if (items != null) {
            _items.value = items!!
        }
    }


    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<List<ReceipEntity>> =
        NotNullMutableLiveData(arrayListOf())
    val itemsLocal: NotNullMutableLiveData<List<ReceipEntity>>
        get() = _items


    fun getAllItems() {
//        var mAppDataBase: AppDataBase? = AppDataBase.invoke(getApplicationContext())
//        AsyncTask.execute(Runnable {
//            try {
//                mAppDataBase?.getReceipDao()?.let {
//                    var itemList: List<ReceipEntity> = it.findAll()
//                    _items.postValue(itemList)
//                }
//            } catch (e: Exception) {
//                e.message?.let {
//                    var mError: String = it
//                    Toast.makeText(getApplicationContext(), mError, Toast.LENGTH_LONG).show()
//                }
//            }
//        })

         useCaseItemLocal.executeRetreiveAllDataLocally(this)


    }

}