package com.example.week2.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.databinding.ActivityLoginFrontBinding
import com.example.week2.tutorial.TutorialActivity

class LoginFrontActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginFrontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginFrontBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClick()
    }

    private fun btnClick() {
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginDetailActivity::class.java)
            startActivity(intent)
        }
    }
}