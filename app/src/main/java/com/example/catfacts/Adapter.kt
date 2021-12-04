package com.example.catfacts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.serverfiles.CatImage
import com.example.catfacts.serverfiles.Fact

class Adapter( private val listener:(Any) -> Unit) : RecyclerView.Adapter<Adapter.CatHolder>() {
    private var catFacts: List<Fact> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return CatHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {

        holder.text.text = catFacts[position].fact
        holder.openButton.setOnClickListener{
            listener(catFacts[position].fact)
        }
    }

    override fun getItemCount(): Int {
        return catFacts.size
    }


    class CatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text: TextView = itemView.findViewById<TextView>(R.id.factView)
        val openButton: Button = itemView.findViewById<Button>(R.id.openButton)
        fun bind(fact: Fact, catImage: CatImage) {
        }


    }
    fun setData(data: List<Fact>) {
        Log.d("setData", "data$data")
        this.catFacts = data
        notifyDataSetChanged()
    }

}