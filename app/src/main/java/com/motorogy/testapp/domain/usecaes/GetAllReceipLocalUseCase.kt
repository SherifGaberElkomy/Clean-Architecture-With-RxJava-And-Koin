package com.motorogy.testapp.domain.usecaes

import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.ui.callbackinterface.IRetreiveAllData

interface GetAllReceipLocalUseCase {
    fun executeSaveDataLocally(receipModel: ReceipDoamainModel)
    fun executeRetreiveAllDataLocally(callBkItemRetreiveAllData: IRetreiveAllData): List<ReceipEntity>?
}