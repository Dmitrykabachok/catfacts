package com.example.catfacts

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.catfacts.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)

        CoroutineScope(IO).launch {
            val adapterList = ArrayList<Fact>()
            adapterList.add(Fact("Empty Fact"))
            adapterList.add(Fact("Empty Fact"))
            adapterList.add(Fact("Empty Fact"))
            withContext(Dispatchers.Main){
                recyclerView.adapter = Adapter(adapterList){fragmentListener(Fact(String()))}
            }
        }



    }

    fun fragmentListener(fact: Fact){
        val nextFrag = NewFragment()
        val bundle = Bundle()
        bundle.putString("fact", fact.fact)
        nextFrag.arguments = bundle
        supportFragmentManager.beginTransaction().replace(
            R.id.container,
            NewFragment(),
            "findThisFragment"
        ).addToBackStack(null).commit()
    }

    fun adapterList(): ArrayList<Fact>{

        val list = ArrayList<Fact>()
        CoroutineScope(IO).launch {
            Log.d("ADAPTER_LIST", "CREATED")
            list.add(Server.getFact())

        }
        return list
    }
}