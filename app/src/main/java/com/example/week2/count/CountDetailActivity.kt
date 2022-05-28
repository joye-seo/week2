package com.example.week2.count

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityCountDetailBinding

class CountDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTimeData()

        binding.btnStart.setOnClickListener {

            countDownTimer()

        }

    }


    fun start() {

    }

    fun pause() {

    }

    override fun onStart() {
        super.onStart()

    }


    private fun time(stop: Unit) {
        binding.btnStart.setOnClickListener {
            start()
        }
    }


    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "다시돌아오셨네요:)!!", Toast.LENGTH_SHORT).show()

    }


    override fun onStop() {
        super.onStop()

    }

    private fun getTimeData() {

        binding.tvHour.text = intent.getStringExtra("hour")
        binding.tvMinute.text = intent.getStringExtra("minute")
        binding.tvSecond.text = intent.getStringExtra("second")


    }

    private fun countDownTimer() {

        val getHour = intent.getStringExtra("hour")!!.toLong()
        val getMinute = intent.getStringExtra("minute")!!.toLong()
        val getSecond = intent.getStringExtra("second")!!.toLong()

        Log.d("test1", "$getHour")

        var totalTime = (getHour * 60 * 60 * 1000) + (getMinute * 60 * 1000) + (getSecond * 1000)

        Log.d("test2", "$totalTime")


        val time = object : CountDownTimer(totalTime, 1000) {

            override fun onTick(p0: Long) {

                totalTime = p0 - 1000

                Log.d("test4", "$totalTime")

                binding.tvHour.text = (totalTime / (60 * 60 * 1000)).toString()
                binding.tvMinute.text = (totalTime % (60 * 60 * 1000) / (60 * 1000)).toString()
                binding.tvSecond.text = (totalTime % (60 * 60 * 1000) % (60 * 1000) / 1000).toString()

            }

            override fun onFinish() {
                totalTime <1000
            }

        }
        time.start()

        binding.btnReset.setOnClickListener {
            time.cancel()
            Log.d("test5", "$totalTime")
        }
    }


    private fun updateRemainTime(remainSec: Long) {
        val remainSecond = remainSec / 60
    }


}