package com.motorogy.testapp.domain.usecaes

import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.domain.repositeries.GetAllReceipLocalData

class GetAllReceipLocalUseCaseImpl(private val getAllReceipDataRepositery: GetAllReceipLocalData): GetAllReceipLocalUseCase {

    override fun executeRetreiveDataLocally(receipModel: ReceipDoamainModel) {
        getAllReceipDataRepositery.saveToReceip(receipModel)
    }
}