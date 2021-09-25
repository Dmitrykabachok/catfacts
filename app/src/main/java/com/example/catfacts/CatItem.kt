package com.example.catfacts

import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
/*
class CatItem {

    updateButton.setOnClickListener{
        CoroutineScope(Dispatchers.IO).launch {
            val fact = Server.getFact()
            val image = Server.getImage()
            withContext(Dispatchers.Main){
                textView.text = fact.fact
                try {
                    Glide.with(this@MainActivity).load(image[0].imageUrl).into(imageView)
                }
                catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
    }
}
}

 */