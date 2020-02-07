package com.motorogy.testapp.domain.repositeries

import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.ui.callbackinterface.IRetreiveAllData

interface GetAllReceipLocalData {
    fun saveToReceip(receipModel: ReceipDoamainModel)
    fun getAllItems(callBackItemRetreiveAllData: IRetreiveAllData): List<ReceipEntity>?
}