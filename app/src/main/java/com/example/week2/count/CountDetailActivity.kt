package com.example.week2.count

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityCountDetailBinding
import java.util.*
import kotlin.concurrent.timer

class CountDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountDetailBinding

    private var currentCountDownTimer: CountDownTimer? = null

    private lateinit var mHandler: Handler

    private var hour = binding.tvHour.text
    private var minute = binding.tvMinute.text
    private var second = binding.tvSecond.text

    private var time  = "$hour : $minute :$second "

    private var mTimeLeftInMills = time

    var timerTask: Timer? = null
    var started = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTimeData()

        time()
    }


    fun start() {

    }

    fun pause() {

    }

    fun stop() {
        started = false
        getTimeData()
    }

    override fun onStart() {
        super.onStart()
    }


    private fun time() {
        binding.btnStart.setOnClickListener {
           start() }


    }


    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "다시돌아오셨네요:)!!", Toast.LENGTH_SHORT).show()

    }


    override fun onStop() {
        super.onStop()
    }

    private fun getTimeData() {
        hour = intent.getStringExtra("hour")
        minute = intent.getStringExtra("minute")
        second = intent.getStringExtra("second")
    }

    private fun stopCountDown() {
        currentCountDownTimer?.cancel()
        currentCountDownTimer = null
    }

    private fun stop2CountDown() {
        currentCountDownTimer?.cancel()
    }

    private fun createCountDownTimer(initialMillis: Long): CountDownTimer {
        return object : CountDownTimer(initialMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                //1초마다 한번씩 불림
                updateRemainTime(millisUntilFinished)
            }

            override fun onFinish() {
                completeCountDown()
            }
        }

    }

    private fun completeCountDown() {
        updateRemainTime(0)
    }

    private fun updateRemainTime(remainMillis: Long) {
        val remainSecond = remainMillis / 1000
        binding.tvMinute.text = "%02d".format(remainSecond / 60)
        binding.tvSecond.text = "%02d".format(remainSecond % 60)
    }

}