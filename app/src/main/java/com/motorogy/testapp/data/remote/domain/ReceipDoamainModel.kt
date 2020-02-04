package com.motorogy.testapp.data.remote.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList

data class ReceipDoamainModel (
@SerializedName("id") val id: Int,
@SerializedName("title") val title: String,
@SerializedName("readyInMinutes") val readyInMin: Int,
@SerializedName("servings") val serving: Int,
@SerializedName("image") val imgItem: String,
@SerializedName("imageUrls") val imgLst: ArrayList<String>
): Serializable