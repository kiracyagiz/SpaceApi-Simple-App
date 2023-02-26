package com.example.mobileapp_master.ui.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp_master.Data.Location
import com.example.mobileapp_master.databinding.LocationCardBinding
import com.example.mobileapp_master.setPicture

class LocationAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<LocationAdapter.LocationHolder>(){


    private val locationList = ArrayList<Location>()

    inner class LocationHolder(val itembinding : LocationCardBinding) : RecyclerView.ViewHolder(itembinding.root){

        fun bind(location: Location) = with(itembinding){

            itemTitle.text = location.name
           // itemBody.text = location.type
            myImageView.setPicture(location.img_url)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
        return LocationHolder(LocationCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {

        val locatonList  = locationList[position]
        holder.bind(locatonList)
        holder.itemView.setOnClickListener {

            listener.onLocationClick(locatonList)

        }
    }

    fun setData(list: ArrayList<com.example.mobileapp_master.Data.Location>) {
        locationList.clear()
        locationList.addAll(list)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int = locationList.size

    interface OnItemClickListener{
        fun onLocationClick(location: Location)
    }

}