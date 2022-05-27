package com.example.week2.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.week2.R
import com.example.week2.adapter.MainViewPagerAdapter
import com.example.week2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mMainViewPagerAdapter: MainViewPagerAdapter

    private var waitTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager()
        bottomNav()
    }

    private fun viewPager() {
        mMainViewPagerAdapter = MainViewPagerAdapter(this)
        binding.viewPagerMain.adapter = mMainViewPagerAdapter

        binding.viewPagerMain.offscreenPageLimit = 5


        //viewpager 움직일 때 마다 icon도 같이 움직임!
        binding.viewPagerMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun bottomNav() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> binding.viewPagerMain.currentItem = 0
                R.id.chart -> binding.viewPagerMain.currentItem = 1
                R.id.profile -> binding.viewPagerMain.currentItem = 2
            }
            true
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 1500) {
            waitTime = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish() // 액티비티 종료
        }
    }
}


