package com.motorogy.testapp.domain.usecaes

import com.motorogy.testapp.domain.model.ReceipDoamainModel

interface GetAllReceipLocalUseCase {
    fun executeRetreiveDataLocally(receipModel: ReceipDoamainModel)
}