package com.example.mobileapp_master.ui.location.locationdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mobileapp_master.R
import com.example.mobileapp_master.databinding.FragmentLocationBinding
import com.example.mobileapp_master.databinding.FragmentLocationDetailBinding
import com.example.mobileapp_master.databinding.FragmentSecondBinding
import com.example.mobileapp_master.setPicture


class LocationDetail : Fragment() {

    private var _binding : FragmentLocationDetailBinding? = null
    private val binding get() = _binding!!
    private val args: LocationDetailArgs by navArgs()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLocationDetailBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val locations = args.location

        binding.imageView.setPicture(locations.img_url)

        binding.nameText.text = locations.name
        binding.typeText.text = locations.type
        binding.inhabitantsText.text =  locations.inhabitants?.joinToString("\n")


    }


}