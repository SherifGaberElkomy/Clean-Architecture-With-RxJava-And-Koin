package com.motorogy.testapp.data.repositeries

import android.os.AsyncTask
import android.os.Handler
import android.widget.Toast
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.domain.repositeries.GetAllReceipLocalData
import com.motorogy.testapp.ui.callbackinterface.IRetreiveAllData
import com.motorogy.testapp.ui.receip.ReceipActivity
import com.motorogy.testapp.util.ioThread

class GetAllReceipLocalDataImpl : GetAllReceipLocalData {

        var mItemList: List<ReceipEntity>? = null


    override fun getAllItems(callBackItemRetreiveAllData: IRetreiveAllData): List<ReceipEntity>? {
//        var mAppDataBase: AppDataBase? = AppDataBase.invoke(AppClassApplication.mContext)
//        AsyncTask.execute(Runnable {
//            try {
//                mAppDataBase?.getReceipDao()?.let {
//                    mItemList = it.findAll()
//                }
//            } catch (e: Exception) {
//                e.message?.let {
//                    var mError: String = it
//                    Toast.makeText(AppClassApplication.mContext, mError, Toast.LENGTH_LONG).show()
//                }
//            }
//        })

            var mAsyncItem: AsynckExecuteRetreiveAllData = AsynckExecuteRetreiveAllData(callBackItemRetreiveAllData)
            mAsyncItem.execute()

        return mItemList
    }


    override fun saveToReceip(receipModel: ReceipDoamainModel) {
        ioThread {
            try {
                var mAppDataBase: AppDataBase? = AppDataBase.invoke(AppClassApplication.mContext)
                AppDataBase.invoke(AppClassApplication.mContext)?.let {
                    var mAppDataBase: AppDataBase = it
                    var mReceipEntity: ReceipEntity =
                        com.motorogy.testapp.data.db.entity.ReceipEntity.toReceip(receipModel)
                    var mLongItem: Long = mAppDataBase.getReceipDao().insert(mReceipEntity)

                    ReceipActivity.mActivityRunThread.runOnUiThread(Runnable {
                        Toast.makeText(
                            AppClassApplication.mContext,
                            "Data has been saved local....",
                            Toast.LENGTH_LONG
                        ).show()
                    })
                }
            } catch (e: Exception) {
            }
        }
    }


    class AsynckExecuteRetreiveAllData(callBkItemRetreiveAllData: IRetreiveAllData): AsyncTask<Void, Void, List<ReceipEntity>?>(){
        var mAppDataBase: AppDataBase? = AppDataBase.invoke(AppClassApplication.mContext)
        var mItemList: List<ReceipEntity>? = null
        lateinit var mCallBkItemRetreiveAllData: IRetreiveAllData
        init {
         mCallBkItemRetreiveAllData = callBkItemRetreiveAllData
        }
        override fun doInBackground(vararg p0: Void?): List<ReceipEntity>? {
            try {
                mAppDataBase?.getReceipDao()?.let {
                    mItemList = it.findAll()
                }
            } catch (e: Exception) {
                e.message?.let {
                    var mError: String = it
                    Toast.makeText(AppClassApplication.mContext, mError, Toast.LENGTH_LONG).show()
                }
            }
            return mItemList
        }

        override fun onPostExecute(result: List<ReceipEntity>?) {
            super.onPostExecute(result)
            if(result != null){
                mItemList = result
                mCallBkItemRetreiveAllData.retreiveAllData(mItemList)
            }
        }


    }





}