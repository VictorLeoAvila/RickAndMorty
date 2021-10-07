package com.rickandmorty.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.R
import com.rickandmorty.data.model.Result
import com.squareup.picasso.Picasso

class CharacterAdapter(private val context: Context,
                       private val characterList: List<Result>):
    RecyclerView.Adapter<CharacterViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentList = characterList.elementAt(position)
        Picasso.get().load(currentList.image).into(holder.personImage)
        holder.personName.text = currentList.name
    }

    override fun getItemCount() = characterList.size
}