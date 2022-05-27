package com.example.week2.tutorial

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.week2.R
import com.example.week2.adapter.TutorialViewPagerAdapter
import com.example.week2.databinding.ActivityMainBinding
import com.example.week2.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    private var waitTime = 0L

    private lateinit var mTutorialViewPagerAdapter: TutorialViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager()
    }

    private fun viewPager() {
        mTutorialViewPagerAdapter = TutorialViewPagerAdapter(this)
        binding.viewPagerTutorial.adapter = mTutorialViewPagerAdapter
        binding.viewPagerTutorial.offscreenPageLimit = 3


        //viewpager 움직일 때 마다 icon도 같이 움직임!
        binding.viewPagerTutorial.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.progressBar.progress = position + 1
            }
        })
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