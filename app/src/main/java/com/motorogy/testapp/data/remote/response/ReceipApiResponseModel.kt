package com.motorogy.testapp.data.remote.response

import com.google.gson.annotations.SerializedName
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import java.util.ArrayList

data class ReceipApiResponseModel (
    @SerializedName("results") val resultLst: ArrayList<ReceipDoamainModel>,
    @SerializedName("baseUri") val baseUri: String,
    @SerializedName("offset") val offst: Int,
    @SerializedName("number") val num: Int,
    @SerializedName("totalResults") val totalResult: Int,
    @SerializedName("processingTimeMs") val processRes: Int,
    @SerializedName("expires") val expires: Long,
    @SerializedName("isStale") val isStable: Boolean
)