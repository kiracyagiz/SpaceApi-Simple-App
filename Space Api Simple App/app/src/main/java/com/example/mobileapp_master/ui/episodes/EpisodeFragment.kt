package com.example.mobileapp_master.ui.episodes

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapp_master.Data.Episode
import com.example.mobileapp_master.Data.Location
import com.example.mobileapp_master.R
import com.example.mobileapp_master.databinding.FragmentEpisodeBinding
import com.example.mobileapp_master.databinding.FragmentHomeBinding
import com.example.mobileapp_master.ui.episodes.episodeDetails.PopUpFragment
import com.example.mobileapp_master.ui.home.HomeAdapter
import com.example.mobileapp_master.ui.location.LocationAdapter
import com.example.mobileapp_master.ui.location.LocationFragmentDirections
import com.example.mobileapp_master.viewmodel.BaseViewModel


class EpisodeFragment : Fragment(R.layout.fragment_episode),EpisodeAdapter.OnItemClickListener {

    private var _binding: FragmentEpisodeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { EpisodeAdapter(this) }
    private val viewModel : BaseViewModel by viewModels()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        _binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myrecycler.adapter = adapter
        binding.myrecycler.layoutManager =LinearLayoutManager(requireContext())
        getData()




    }



    private fun getData() = with(binding){

        viewModel.episode.observe(viewLifecycleOwner){
            Log.d("Episode", it.toString())
            adapter.setData(it)
        }

    }


    override fun onEpisodeClick(episode: Episode) {
        val action = EpisodeFragmentDirections.actionEpisodeFragmentToPopUpFragment(episode)
        findNavController().navigate(action)

    }




}

