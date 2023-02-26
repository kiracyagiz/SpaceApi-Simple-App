package com.example.mobileapp_master.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapp_master.Data.Character
import com.example.mobileapp_master.R
import com.example.mobileapp_master.databinding.FragmentHomeBinding
import com.example.mobileapp_master.viewmodel.BaseViewModel


class HomeFragment() : Fragment(R.layout.fragment_home), HomeAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { HomeAdapter(this) }
    private val viewModel : BaseViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myrecycler.adapter = adapter
        binding.myrecycler.layoutManager = LinearLayoutManager(requireContext())
        getData()




    }

    private fun getData() = with(binding){

        viewModel.character.observe(viewLifecycleOwner){

            adapter.setData(it)

        }

    }

    override fun onCharacterClick(character: Character) {
        val action = HomeFragmentDirections.actionHomeFragmentToSecondFragment(character)

        findNavController().navigate(action)
    }
}