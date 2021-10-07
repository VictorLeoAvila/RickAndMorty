package com.rickandmorty.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.R

class CharacterViewHolder(itemView: View):
    RecyclerView.ViewHolder(itemView) {
        val personImage = itemView.findViewById<ImageView>(R.id.itemImageList)
        val personName = itemView.findViewById<TextView>(R.id.itemNameList)
}