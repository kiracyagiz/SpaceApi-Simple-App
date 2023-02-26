package com.example.mobileapp_master.ui.onboarding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileapp_master.R
import com.example.mobileapp_master.databinding.FragmentThirdScreenBinding
import com.example.mobileapp_master.databinding.FragmentViewPager2Binding


class ThirdScreen : Fragment() {
    private var _binding: FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.textView4.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        activity?.actionBar?.hide()


        return view
    }


}