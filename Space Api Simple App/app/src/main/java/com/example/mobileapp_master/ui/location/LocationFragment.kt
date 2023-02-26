package com.example.mobileapp_master.ui.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapp_master.Data.Location
import com.example.mobileapp_master.R
import com.example.mobileapp_master.databinding.FragmentHomeBinding
import com.example.mobileapp_master.databinding.FragmentLocationBinding
import com.example.mobileapp_master.ui.home.HomeAdapter
import com.example.mobileapp_master.viewmodel.BaseViewModel

class LocationFragment : Fragment(R.layout.fragment_location) ,LocationAdapter.OnItemClickListener{

    private  var _binding : FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { LocationAdapter(this) }
    private val viewModel : BaseViewModel by viewModels()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.locationrecycler.adapter = adapter
        binding.locationrecycler.layoutManager = GridLayoutManager(context,2)
        getData()


    }

    private fun getData() = with(binding){

        viewModel.location.observe(viewLifecycleOwner){

            adapter.setData(it)

        }

    }


    override fun onLocationClick(location: Location) {
        val action = LocationFragmentDirections.actionLocationFragmentToLocationDetail(location)
        findNavController().navigate(action)

    }


}