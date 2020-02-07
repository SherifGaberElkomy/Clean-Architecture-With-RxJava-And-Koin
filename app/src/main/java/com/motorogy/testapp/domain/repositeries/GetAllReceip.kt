package com.motorogy.testapp.domain.repositeries

import android.widget.Toast
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.ui.receip.ReceipActivity
import com.motorogy.testapp.util.ioThread
import io.reactivex.Single

interface GetAllReceip {
    fun getAllReceip(keyApiParam: String): Single<ReceipApiResponseModel>
}