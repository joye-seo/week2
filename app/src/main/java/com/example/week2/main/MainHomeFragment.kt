package com.example.week2.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week2.CountActivity
import com.example.week2.databinding.FragmentMainHomeBinding
import java.util.*

class MainHomeFragment : Fragment() {

    private var _binding: FragmentMainHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentTime()
        countActivityMove()
    }

    private fun countActivityMove(){
        binding.fabCount.setOnClickListener {
            val intent = Intent(activity,CountActivity::class.java)
            startActivity(intent)
        }
    }


    private fun currentTime() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DATE)
        val hour = cal.get(Calendar.HOUR)
        val minute = cal.get(Calendar.MINUTE)

        binding.tvDate.text ="${year}년 ${ month+1 }월 ${day}일 ${hour}시 ${minute}분"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}