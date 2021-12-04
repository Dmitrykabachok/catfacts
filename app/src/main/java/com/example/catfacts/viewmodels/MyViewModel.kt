package com.example.catfacts.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catfacts.serverfiles.Fact
import com.example.catfacts.serverfiles.Server
import android.util.Log
import kotlinx.coroutines.*

class MyViewModel : ViewModel() {
    val catFactsList: MutableLiveData<List<Fact>> = MutableLiveData<List<Fact>>()
    val factsLoadingStatus: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun loadFacts() {
        factsLoadingStatus.setValue(false)
        runBlocking {
            launch {

                catFactsList.setValue(Server.getFacts().data)
                Log.d("viewmodel", "data${catFactsList.value}")
                factsLoadingStatus.setValue(true)
            }
        }
    }


}