package com.example.spacechatapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.top.TopFragment
import com.example.spacechatapp.presentation.bottom.BottomFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.topFragment.id, TopFragment())
            .add(binding.bottomFragment.id, BottomFragment())
            .commit()
    }
}