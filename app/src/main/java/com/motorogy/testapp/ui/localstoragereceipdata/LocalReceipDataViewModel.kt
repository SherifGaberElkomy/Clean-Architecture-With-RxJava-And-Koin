package com.motorogy.testapp.ui.localstoragereceipdata

import android.os.AsyncTask
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.core.BaseViewModel
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.dao.ReceipDao
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import com.motorogy.testapp.ui.receip.ReceipActivity
import com.motorogy.testapp.util.NotNullMutableLiveData
import com.motorogy.testapp.util.ioThread
import org.w3c.dom.Entity
import java.util.ArrayList

class LocalReceipDataViewModel(private val dao: ReceipDao) : BaseViewModel() {


    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<List<ReceipEntity>> = NotNullMutableLiveData(arrayListOf())
    val itemsLocal: NotNullMutableLiveData<List<ReceipEntity>>
        get() = _items

    fun getAllItems() {
        var mAppDataBase: AppDataBase? = AppDataBase.invoke(getApplicationContext())
        AsyncTask.execute(Runnable {
            try {
                mAppDataBase?.getReceipDao()?.let {
                    var itemList: List<ReceipEntity> = it.findAll()
                    _items.postValue(itemList)
                }
            } catch (e: Exception) {
                e.message?.let {
                    var mError: String = it
                    Toast.makeText(getApplicationContext(), mError, Toast.LENGTH_LONG).show()

                }

            }

        })

    }

//    fun delete(receipEntityObject: ReceipEntity) = ioThread {
//        dao.delete(receipEntityObject)
//
//    }
}