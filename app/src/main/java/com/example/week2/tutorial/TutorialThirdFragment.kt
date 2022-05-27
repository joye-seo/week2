package com.example.week2.tutorial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week2.databinding.FragmentMainHomeBinding
import com.example.week2.databinding.FragmentTutorialThirdBinding
import com.example.week2.main.MainActivity
import java.util.*

class TutorialThirdFragment : Fragment() {

    private var _binding: FragmentTutorialThirdBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTutorialThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}