package com.example.mobileapp_master.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(list:ArrayList<Fragment>,fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm,lifecycle) {

    val fragmentlist = list

    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment  = fragmentlist[position]
}