package com.example.catfacts

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.catfacts.R
import com.example.catfacts.serverfiles.Server
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class FactActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var toolbar_layout:CollapsingToolbarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fact_activity)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        textView = findViewById(R.id.activity_textView)
        imageView = findViewById(R.id.activity_image)
        toolbar = findViewById(R.id.main_toolbar)
        toolbar_layout = findViewById(R.id.collapsingLayout)

        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener{
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar_layout.title = "Cats"

        textView.text = message
        CoroutineScope(Dispatchers.IO).launch {
            val tempImage = Server.getImage()
            withContext(Dispatchers.Main) {
                try{
                    Picasso.get().load(tempImage[0].imageUrl).into(imageView)
                }
                catch (e: Exception){

                    Picasso.get().load(R.drawable.default_catimage).into(imageView)
                }
            }
        }
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}