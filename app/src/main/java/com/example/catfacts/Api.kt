package com.example.catfacts

import retrofit2.http.GET

interface Api {
    @GET("fact")
    suspend fun getFact():Fact
    @GET("search")
    suspend fun getImage():ArrayList<CatImage>
    @GET("facts")
    suspend fun getFacts():Facts
}