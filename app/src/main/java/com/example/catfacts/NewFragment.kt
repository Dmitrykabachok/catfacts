package com.example.catfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewFragment : Fragment() {
    lateinit var factView: TextView
    lateinit var catImageView: ImageView
    lateinit var fragmentFact: String

    companion object {
        fun newInstance(fact: String) = NewFragment().apply {
            Bundle(1).apply {
                putString(fragmentFact, fact)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.new_fragment, container, false)

        factView = view.findViewById(R.id.fragmentFactView)
        catImageView = view.findViewById(R.id.catImage)
        CoroutineScope(Dispatchers.IO).launch {
            val tempImage = Server.getImage()
            factView.text = fragmentFact
            withContext(Dispatchers.Main) {
                Picasso.get().load(tempImage[0].imageUrl).into(catImageView)
            }
        }

        return view
    }
}