package com.example.week2.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
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
        spannable()
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

    private fun spannable() {

        val spannable = SpannableStringBuilder("루티너리는 행동 과학 타이머로\n여러분의 습관을 만들어줘요.")
        spannable.setSpan(
            ForegroundColorSpan(Color.GRAY),
            4, // start
            32, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        binding.tvContent.text = spannable

        val spannableString = SpannableString("이미 가입하셨나요? 로그인하기")
        spannableString.setSpan(
            UnderlineSpan(),
            10,
            13,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.btnLogin.text = spannableString
    }
}
