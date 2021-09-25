package com.example.catfacts

import com.google.gson.annotations.SerializedName

data class Facts (
    @SerializedName("data") val data: ArrayList<Fact>

)