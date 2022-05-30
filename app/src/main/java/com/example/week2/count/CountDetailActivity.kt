package com.example.week2.count

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityCountDetailBinding
import java.text.DecimalFormat

class CountDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

    private var saveHour = 0L
    private var saveMinute = 0L
    private var saveSecond = 0L

    private fun countFirstDownTimer() {

        val getHour = intent.getStringExtra("hour")!!.toLong()
        val getMinute = intent.getStringExtra("minute")!!.toLong()
        val getSecond = intent.getStringExtra("second")!!.toLong()

        var totalTime = (getHour * 60 * 60 * 1000) + (getMinute * 60 * 1000) + (getSecond * 1000) + 1000

        var time = object : CountDownTimer(totalTime, 1000) {

            override fun onTick(p0: Long) {

                totalTime = p0

                // 2자리 수 구현을 위해 사용함
                val df1 = DecimalFormat("00")

                val hour = df1.format(totalTime / (60 * 60 * 1000))
                val minute = df1.format(totalTime % (60 * 60 * 1000) / (60 * 1000))
                val second = df1.format(totalTime % (60 * 60 * 1000) % (60 * 1000) / 1000)

                binding.tvHour.text = hour.toString()
                binding.tvMinute.text = minute.toString()
                binding.tvSecond.text = second.toString()

                saveHour = hour.toLong()
                saveMinute = minute.toLong()
                saveSecond = second.toLong()

            }

            override fun onFinish() {
                totalTime < 1000
            }
        }
        time.start()

        binding.btnRestart.setOnClickListener {

            var reminingTime = (saveHour * 60 * 60 * 1000) + (saveMinute * 60 * 1000) + (saveSecond * 1000) + 1000


            Log.d("restart1", saveHour.toString())
            Log.d("restart1", saveMinute.toString())

            Log.d("restart2", reminingTime.toString())

            totalTime = reminingTime

            Log.d("restart", reminingTime.toString())
            Log.d("restart", totalTime.toString())

            time.onTick(totalTime)
            time.start()

            Log.d("restart3", totalTime.toString())

        }

        binding.btnPause.setOnClickListener {
            time.cancel()
            Log.d("test5", "$totalTime")
        }
    }
}