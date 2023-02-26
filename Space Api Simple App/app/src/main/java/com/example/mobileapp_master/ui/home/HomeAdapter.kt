package com.example.mobileapp_master.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp_master.databinding.PostItemBinding
import com.example.mobileapp_master.setPicture
import com.example.mobileapp_master.Data.Character

class HomeAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.MyHolder>() {

    private var characterList = ArrayList<Character>()

    inner class MyHolder(val itemBinding: PostItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(character: Character) = with(itemBinding){


            itemTitle.text = character.name
            itemBody.text = character.status
            myImageView.setPicture(character.img_url)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


        val characterList  = characterList[position]
        holder.bind(characterList)
        holder.itemView.setOnClickListener {

            listener.onCharacterClick(characterList)

        }

    }



    override fun getItemCount(): Int  = characterList.size

    fun setData(list: ArrayList<Character>) {
        characterList.clear()
        characterList.addAll(list)
        notifyDataSetChanged()

    }

    interface OnItemClickListener{
        fun onCharacterClick(character:Character)
    }

}