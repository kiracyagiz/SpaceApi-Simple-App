package com.example.mobileapp_master.ui.episodes.episodeDetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.mobileapp_master.R
import com.example.mobileapp_master.databinding.FragmentLocationDetailBinding
import com.example.mobileapp_master.setPicture
import com.example.mobileapp_master.ui.location.locationdetail.LocationDetailArgs
import org.w3c.dom.Text

class PopUpFragment : DialogFragment() {

    private val args: PopUpFragmentArgs by navArgs()





    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_pop_up, container, false)

        val title = view.findViewById<TextView>(R.id.itemTitle)
        val title2 = view.findViewById<TextView>(R.id.itemTitle2)
        val title3 = view.findViewById<TextView>(R.id.itemTitle3)
        val title4 = view.findViewById<TextView>(R.id.itemTitle4)
        val myImage = view.findViewById<ImageView>(R.id.imageView3)


        val episode = args.episode

        title.text = episode.airDate
        title2.text = episode.director
        title3.text  = episode.writer
        title4.text = episode.name
        myImage.setPicture(episode.img_url)

        return view

    }


}