package com.motorogy.testapp.ui.callbackinterface

import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel

interface ICallBackClick {
    fun navigateItemToDetails(receipModel: ReceipDoamainModel)
}