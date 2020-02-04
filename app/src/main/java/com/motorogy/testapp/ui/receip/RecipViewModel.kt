package com.motorogy.testapp.ui.receip

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.core.BaseViewModel
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.dao.ReceipDao
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.api.ReceipAPI
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import com.motorogy.testapp.data.remote.response.ReceipApiResponseModel
import com.motorogy.testapp.ui.receipdetails.ReceipDetailsActivity
import com.motorogy.testapp.util.NotNullMutableLiveData
import com.motorogy.testapp.util.ioThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList


class RecipViewModel(private val api: ReceipAPI) : BaseViewModel() {
    private var query: String = ""
        get() = if (field.isEmpty()) "MVVM" else field

   //  private val dao: ReceipDao = ReceipDao

    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<ArrayList<ReceipDoamainModel>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<ArrayList<ReceipDoamainModel>>
        get() = _items

    fun doSearch() {

        val params: String = "9d17ab17e29848599905f1bdc3b14016"

        addToDisposable(api.getSearchResult(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<ReceipApiResponseModel>(){
                override fun onSuccess(t: ReceipApiResponseModel) {
                    _items.value = t.resultLst
                }

                override fun onError(e: Throwable) {
                    e.message?.let {
                        var mStringError: String = it
                    }
                }


            }))

    }

    fun onQueryChange(receipModel: ReceipDoamainModel) {
    //    this.query = query.toString()
        var mIntent: Intent = Intent(getApplicationContext(), ReceipDetailsActivity::class.java)
        mIntent.putExtra("recipItem", receipModel)
        ReceipActivity.mActivityRunThread.startActivity(mIntent)
    }

//    fun saveToReceip(receipModel: ReceipDoamainModel) = ioThread { dao.insert(ReceipEntity.toReceip(receipModel)) }

//    fun saveToReceip(receipModel: ReceipDoamainModel){
//        AppDataBase.getInstance(getApplicationContext()).getReceipDao().insert(ReceipEntity.toReceip(receipModel))
//    }


    fun saveToReceip(receipModel: ReceipDoamainModel) = ioThread {
        try {
            var mAppDataBase: AppDataBase? = AppDataBase.invoke(getApplicationContext())

            AppDataBase.invoke(getApplicationContext())?.let {
                var mAppDataBase: AppDataBase = it
                var mReceipEntity: ReceipEntity = com.motorogy.testapp.data.db.entity.ReceipEntity.toReceip(receipModel)
                var mLongItem: Long = mAppDataBase.getReceipDao().insert(mReceipEntity)

                ReceipActivity.mActivityRunThread.runOnUiThread(Runnable {
                    Toast.makeText(AppClassApplication.mContext, "Data has been saved local....", Toast.LENGTH_LONG).show()
                })

            }


            fun goToDetails(receipModel: ReceipDoamainModel) = ioThread {


            }



//            AppDataBase.getInstance(getApplicationContext())?.let {
//                var mReceipDao: ReceipDao =it.getReceipDao()
//                mReceipDao.insert(ReceipEntity.toReceip(receipModel))
//            }

        //    AppDataBase.getInstance(getApplicationContext())?.getReceipDao().insert(ReceipEntity.toReceip(receipModel))
        }catch (e: Exception){
            e.message?.let {
                var mError: String = it
            }

        }

    }

}