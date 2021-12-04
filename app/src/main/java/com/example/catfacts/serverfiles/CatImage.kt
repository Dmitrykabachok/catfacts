package com.example.catfacts.serverfiles

import com.google.gson.annotations.SerializedName

data class CatImage (
    @SerializedName("breeds") val breeds: List<String>,
    @SerializedName("id") val id: String,
    @SerializedName("url") val imageUrl: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int
)