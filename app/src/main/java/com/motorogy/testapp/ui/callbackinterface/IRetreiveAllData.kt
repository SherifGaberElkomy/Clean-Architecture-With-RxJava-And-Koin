package com.motorogy.testapp.ui.callbackinterface

import com.motorogy.testapp.data.db.entity.ReceipEntity

interface IRetreiveAllData {
    fun retreiveAllData(items: List<ReceipEntity>?)
}