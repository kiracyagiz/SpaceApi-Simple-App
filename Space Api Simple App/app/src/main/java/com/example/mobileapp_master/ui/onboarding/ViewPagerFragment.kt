package com.example.mobileapp_master.ui.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileapp_master.databinding.FragmentViewPager2Binding
import com.example.mobileapp_master.ui.onboarding.fragments.FirstScreen
import com.example.mobileapp_master.ui.onboarding.fragments.SecondScreen
import com.example.mobileapp_master.ui.onboarding.fragments.ThirdScreen


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPager2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()




    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentViewPager2Binding.inflate(inflater, container, false)
        val view = binding.root
        activity?.actionBar?.hide()






        val fragmentList = arrayListOf<Fragment>(

            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle

        )

        binding.myPager.adapter = adapter



        return view


    }


}