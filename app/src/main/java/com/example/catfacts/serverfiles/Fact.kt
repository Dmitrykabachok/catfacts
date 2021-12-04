package com.example.catfacts.serverfiles

import com.google.gson.annotations.SerializedName

data class Fact (
    @SerializedName("fact") val fact: String
)