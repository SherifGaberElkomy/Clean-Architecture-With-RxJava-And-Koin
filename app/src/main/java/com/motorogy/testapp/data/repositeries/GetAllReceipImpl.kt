package com.motorogy.testapp.data.repositeries

import com.motorogy.testapp.data.remote.api.ReceipAPI
import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.domain.repositeries.GetAllReceip
import io.reactivex.Single

class GetAllReceipImpl(private val api: ReceipAPI) : GetAllReceip {
    override fun getAllReceip(keyApiParam: String): Single<ReceipApiResponseModel> {
        return api.getSearchResult(keyApiParam)
    }
}