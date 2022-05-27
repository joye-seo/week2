package com.example.week2

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityCountBinding

class CountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountBinding

    private var currentCountDownTimer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() {
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                if (fromUser) {
                    updateRemainTime(progress * 60 * 1000L)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                stopCountDown()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar ?: return     //seekBar가 null인 경우 return
                if (seekBar.progress == 0) {
                    stopCountDown()
                } else {
                    startCountDown()
                }
            }
        }
        )
    }

    private fun stopCountDown() {
        currentCountDownTimer?.cancel()
        currentCountDownTimer = null
    }

    private fun createCountDownTimer(initialMillis: Long): CountDownTimer {
        return object : CountDownTimer(initialMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                //1초마다 한번씩 불림
                updateRemainTime(millisUntilFinished)
                updateSeekBar(millisUntilFinished)
            }

            override fun onFinish() {
                completeCountDown()
            }
        }

    }

    private fun startCountDown() {
        currentCountDownTimer =
            createCountDownTimer(binding.seekBar!!.progress * 60 * 1000L).start()
        currentCountDownTimer?.start()

    }

    private fun completeCountDown() {
        updateRemainTime(0)
        updateSeekBar(0)

    }

    private fun updateRemainTime(remainMillis: Long) {
        val remainSecond = remainMillis / 1000
        binding.tvMinute.text = "%02d".format(remainSecond / 60)
        binding.tvSecond.text = "%02d".format(remainSecond % 60)
    }

    private fun updateSeekBar(remainMillis: Long) {
        binding.seekBar.progress = (remainMillis / 1000 / 60).toInt()
    }


}