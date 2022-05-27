package com.example.week2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week2.main.MainChartFragment
import com.example.week2.main.MainHomeFragment
import com.example.week2.main.MainProfileFragment

class MainViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainHomeFragment()
            1 -> MainChartFragment()
            else -> MainProfileFragment()
        }
    }
}