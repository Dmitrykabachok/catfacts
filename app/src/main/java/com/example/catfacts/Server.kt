package com.example.catfacts

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.spec.ECField

object Server {
    val gson = GsonBuilder().setLenient().create()

    val api = Retrofit.Builder().baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Api::class.java)

    val secondApi = Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/images/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Api::class.java)


    val factsApi =  Retrofit.Builder().baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Api::class.java)

    suspend fun getFact(): Fact{
        try {

            return api.getFact()
        }
        catch (e: Exception){
             e.printStackTrace()
        }
        return Fact("")
    }

    suspend fun getImage():ArrayList<CatImage>{
        try {

            return secondApi.getImage()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        return ArrayList()
    }


    suspend fun getFacts(): Facts {
        try {
            return factsApi.getFacts()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        return Facts(ArrayList())
    }
}

