package com.example.week2.count

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityCountSelectBinding

class CountSelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        timeSetting()
        numberPicker()
    }

    private fun timeSetting() = with(binding) {

        with(numPickHour) {
            maxValue = 99
            minValue = 0
            value = 0
            wrapSelectorWheel = false
        }

        with(numPickMinute) {
            maxValue = 59
            minValue = 0
            value = 0
            wrapSelectorWheel = false
        }

        with(numPickSecond) {
            maxValue = 59
            minValue = 0
            value = 0
            wrapSelectorWheel = false
        }

    }

    private fun numberPicker() = with(binding) {
        btnDetailCount.setOnClickListener {
            var hour = numPickHour.value
            var minute = "%02d".format(numPickMinute.value)
            var second = "%02d".format(numPickSecond.value)

            val intent = Intent(this@CountSelectActivity, CountDetailActivity::class.java)
            intent.putExtra("hour", hour.toString()).putExtra("minute", minute)
                .putExtra("second", second)
            startActivity(intent)

            Log.d("test", "$minute")
        }
    }
}