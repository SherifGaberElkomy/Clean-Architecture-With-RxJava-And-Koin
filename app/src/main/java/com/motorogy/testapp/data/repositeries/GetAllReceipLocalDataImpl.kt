package com.motorogy.testapp.data.repositeries

import android.widget.Toast
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.domain.repositeries.GetAllReceipLocalData
import com.motorogy.testapp.ui.receip.ReceipActivity
import com.motorogy.testapp.util.ioThread

class GetAllReceipLocalDataImpl : GetAllReceipLocalData {
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
}