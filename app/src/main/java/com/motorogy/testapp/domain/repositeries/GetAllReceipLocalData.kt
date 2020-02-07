package com.motorogy.testapp.domain.repositeries

import com.motorogy.testapp.domain.model.ReceipDoamainModel

interface GetAllReceipLocalData {
    fun saveToReceip(receipModel: ReceipDoamainModel)
}