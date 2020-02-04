package com.motorogy.testapp.ui.callbackinterface

import com.motorogy.testapp.data.db.entity.ReceipEntity

interface ILocalDataDelete {
    fun removeReceipEntityItem(itemReceipEntity: ReceipEntity, lstItem: List<ReceipEntity>, position: Int)
}