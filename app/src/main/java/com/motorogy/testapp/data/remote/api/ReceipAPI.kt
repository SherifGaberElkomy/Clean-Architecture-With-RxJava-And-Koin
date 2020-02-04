package com.motorogy.testapp.data.remote.api

import com.motorogy.testapp.data.remote.response.ReceipApiResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ReceipAPI {
    @GET("/recipes/search")
    fun getSearchResult(@Query("apiKey") params: String): Single<ReceipApiResponseModel>
}