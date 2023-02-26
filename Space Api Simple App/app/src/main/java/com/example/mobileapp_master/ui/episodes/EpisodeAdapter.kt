package com.example.mobileapp_master.ui.episodes

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mobileapp_master.Data.Episode
import com.example.mobileapp_master.Data.Location
import com.example.mobileapp_master.databinding.EpisodeCardBinding
import com.example.mobileapp_master.setPicture
import com.example.mobileapp_master.ui.episodes.episodeDetails.PopUpFragment
import com.example.mobileapp_master.ui.location.LocationAdapter

class EpisodeAdapter(private val listener: EpisodeAdapter.OnItemClickListener) : RecyclerView.Adapter<EpisodeAdapter.MyAdapter>() {

    val episodeList = ArrayList<Episode>()

    inner class MyAdapter(val itemBinding: EpisodeCardBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(episode: Episode) = with(itemBinding){
          //  itemTitle2.text = episode.airDate
            //itemTitle.text = episode.name
            textView.text = episode.name

            
            itemBinding.episodeImage.setPicture(episode.img_url)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter {
        return MyAdapter(EpisodeCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: MyAdapter, position: Int) {
        val episodeList  = episodeList[position]
        holder.bind(episodeList)
        Log.d("AdapterCheck", episodeList.img_url.toString())
        holder.itemView.setOnClickListener {

            listener.onEpisodeClick(episodeList)

        }
    }

    override fun getItemCount(): Int = episodeList.size



    fun setData(list: ArrayList<Episode>) {
        episodeList.clear()
        episodeList.addAll(list)
        notifyDataSetChanged()

    }

    interface OnItemClickListener{
        fun onEpisodeClick(episode: Episode)
    }



}