package com.motorogy.testapp.ui.callbackinterface

import com.motorogy.testapp.domain.model.ReceipDoamainModel

interface ICallBackClick {
    fun navigateItemToDetails(receipModel: ReceipDoamainModel)

}