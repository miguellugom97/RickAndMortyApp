/*
 * *
 *  * Created by Miguel Lugo Moreno on 19/01/22 11:06
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19/01/22 11:06
 *
 */

package com.miguellugo.rickandmortyapp.ui.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.databinding.ItemListCharactersBinding
import com.miguellugo.rickandmortyapp.utils.extension.load

class ListCharacterAdapter(private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<ListCharacterAdapter.MyViewHolder>() {
    interface OnItemClickListener {
        fun onClickCharacter(character: Character)
    }
    var itemList = emptyList<Character>()
    class MyViewHolder(val binding: ItemListCharactersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(character: Character) {
            binding.apply {
                characterImageView.load(character.image)
                nameCharacterTextView.text = character.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bindView(currentItem)
        holder.binding.root.setOnClickListener {
            onItemClickListener.onClickCharacter(currentItem)
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setData(itemList: List<Character>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}