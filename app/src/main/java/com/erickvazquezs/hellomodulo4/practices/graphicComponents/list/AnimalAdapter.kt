package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.erickvazquezs.hellomodulo4.R

class AnimalAdapter(val list: List<AnimalEntity>): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    var onItemSelected: ((AnimalEntity) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)

    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAnimal = view.findViewById<ImageView>(R.id.animalImage)
        val cardAnimal = view.findViewById<CardView>(R.id.animalCard)
        val tvName = view.findViewById<TextView>(R.id.animalName)
        val tvDescription = view.findViewById<TextView>(R.id.animalDescription)

        fun render(animalEntity: AnimalEntity, onItemSelected: ((AnimalEntity) -> Unit)?) {
            tvName.text = animalEntity.name
            tvDescription.text = animalEntity.color
            cardAnimal.setOnClickListener {
                onItemSelected?.invoke(animalEntity)
            }
        }
    }
}