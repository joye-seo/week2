package com.example.week2.login

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityLoginDetailBinding
import com.example.week2.main.MainActivity

class LoginDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            //이전 Activity 스택 다 사라지게 해줌
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}