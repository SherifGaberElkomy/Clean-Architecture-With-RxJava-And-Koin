package com.motorogy.testapp.domain.usecaes

import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.domain.repositeries.GetAllReceipLocalData
import com.motorogy.testapp.ui.callbackinterface.IRetreiveAllData

class GetAllReceipLocalUseCaseImpl(private val getAllReceipDataRepositery: GetAllReceipLocalData): GetAllReceipLocalUseCase {
    override fun executeRetreiveAllDataLocally(callBkItemRetreiveAllData: IRetreiveAllData): List<ReceipEntity>? {
        return  getAllReceipDataRepositery.getAllItems(callBkItemRetreiveAllData)
    }

    override fun executeSaveDataLocally(receipModel: ReceipDoamainModel) {
        getAllReceipDataRepositery.saveToReceip(receipModel)
    }
}