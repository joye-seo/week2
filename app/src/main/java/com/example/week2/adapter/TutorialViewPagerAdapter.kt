package com.example.week2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week2.tutorial.TutorialFirstFragment
import com.example.week2.tutorial.TutorialSecondFragment
import com.example.week2.tutorial.TutorialThirdFragment

class TutorialViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TutorialFirstFragment()
            1 -> TutorialSecondFragment()
            else -> TutorialThirdFragment()
        }
    }
}