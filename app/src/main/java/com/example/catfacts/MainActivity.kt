package com.example.catfacts

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.catfacts.Adapter
import com.example.catfacts.serverfiles.Fact
import com.example.catfacts.R
import com.example.catfacts.serverfiles.Server
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.catfacts.fragments.NewFragment
import com.example.catfacts.viewmodels.MyViewModel

const val EXTRA_MESSAGE = "EXTRA_MESSAGE"

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var pullToRefresh: SwipeRefreshLayout
    lateinit var recyclerViewAdapter: Adapter
    val viewModel = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        viewModel.loadFacts()

        viewModel.catFactsList.observe(this, { model -> Log.d("Loading_facts","data${model}");
            recyclerViewAdapter.setData(model)
        })
        pullToRefresh.setOnRefreshListener {
            viewModel.loadFacts()
            pullToRefresh.isRefreshing = false
        }


        }

fun fragmentListener(fact: Fact) {
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


fun sendMessage(message: String) {

        val intent = Intent(this, FactActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        Log.d("Send_message","sendMessage_call")
        startActivity(intent)
    }

private fun initViews() {
        pullToRefresh = findViewById(R.id.refresher)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerViewAdapter = Adapter { data -> sendMessage("data as String") }
        Log.d("adapter_init","data${recyclerViewAdapter.javaClass}")
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}

