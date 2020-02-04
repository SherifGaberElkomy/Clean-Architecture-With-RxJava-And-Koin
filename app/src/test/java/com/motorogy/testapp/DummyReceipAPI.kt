package com.motorogy.testapp

import com.motorogy.testapp.data.remote.api.ReceipAPI
import com.motorogy.testapp.data.remote.response.ReceipApiResponseModel
import io.reactivex.Single

class DummyReceipAPI: ReceipAPI {

    override fun getSearchResult(params: MutableMap<String, String>): Single<ReceipApiResponseModel> {
        return Single.just(null)
    }

}