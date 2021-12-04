package com.example.catfacts.serverfiles

import com.google.gson.annotations.SerializedName

data class Facts (
    @SerializedName("data") val data: ArrayList<Fact>

)