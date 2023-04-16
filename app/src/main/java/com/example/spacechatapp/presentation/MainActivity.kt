package com.example.spacechatapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacechatapp.R
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.first_screen.FirstFragment
import com.example.spacechatapp.presentation.second_screen.SecondFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.firstFragment.id, FirstFragment())
            .add(binding.secondFragment.id, SecondFragment())
            .commit()
    }
}