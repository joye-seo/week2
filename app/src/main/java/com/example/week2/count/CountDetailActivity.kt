package com.example.week2.count

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityCountDetailBinding
import java.text.DecimalFormat
import kotlin.properties.Delegates

class CountDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountDetailBinding

    private var countStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        getTimeData()
        countFirstDownTimer()

    }

    override fun onStart() {
        super.onStart()
        // binding.btnRestart.callOnClick()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "다시돌아오셨네요:)!!", Toast.LENGTH_SHORT).show()


    }

    override fun onPause() {
        super.onPause()
        binding.btnPause.callOnClick()
    }

    private var getHour = 0L

    private fun countFirstDownTimer() {

        var getHour = intent.getStringExtra("hour")!!.toLong()
        var getMinute = intent.getStringExtra("minute")!!.toLong()
        var getSecond = intent.getStringExtra("second")!!.toLong()

        var totalTime = (getHour * 60 * 60 * 1000) + (getMinute * 60 * 1000) + (getSecond * 1000) + 1000

        val time = object : CountDownTimer(totalTime, 1000) {

            override fun onTick(p0: Long) {

//                val second = (totalTime % (60 * 60 * 1000) % (60 * 1000) / 1000).toString()

                totalTime = p0 - 1000
//                Log.d("test4", "$totalTime")

                val df1 = DecimalFormat("00")

                val hour = totalTime / (60 * 60 * 1000)
                val minute = df1.format(totalTime % (60 * 60 * 1000) / (60 * 1000))
                val second = df1.format(totalTime % (60 * 60 * 1000) % (60 * 1000) / 1000)

                binding.tvHour.text = hour.toString()
                binding.tvMinute.text = minute.toString()
                binding.tvSecond.text = second.toString()


                if (binding.btnRestart.isClickable) {

                }


            }

            override fun onFinish() {
                totalTime < 1000
            }

        }
        time.start()

        binding.btnRestart.setOnClickListener {


            getHour = (totalTime / (60 * 60 * 1000))

            return@setOnClickListener

//            var currentHour = getHour
//            var currentMinute = getMinute
//            var currentSecond = getSecond
//
//            var totalCurrentTime =
//                (currentHour * 60 * 60 * 1000) + (currentMinute * 60 * 1000) + (currentSecond * 1000) + 1000
        }

        binding.btnPause.setOnClickListener {
            time.cancel()
            Log.d("test5", "$totalTime")
        }

    }

}