package com.example.catfacts

import com.google.gson.annotations.SerializedName

data class Fact (
    @SerializedName("fact") val fact: String
)