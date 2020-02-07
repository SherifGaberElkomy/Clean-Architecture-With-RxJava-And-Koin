package com.motorogy.testapp

import com.motorogy.testapp.data.remote.api.ReceipAPI
import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import io.reactivex.Single

 class DummyReceipAPI: ReceipAPI {
     override fun getSearchResult(params: String): Single<ReceipApiResponseModel> {
         return Single.just(null)
     }

}