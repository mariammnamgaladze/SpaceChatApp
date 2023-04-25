package com.example.spacechatapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import com.example.spacechatapp.R
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.chat.ChatFragment
import com.example.spacechatapp.presentation.model.ChatUser

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFragments(savedInstanceState)
        listener()
    }

    private fun setUpFragments(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction().apply {
            if (savedInstanceState == null) {
                add(binding.topFragment.id, ChatFragment(), ChatUser.TOP_USER.name)
                add(binding.bottomFragment.id, ChatFragment(), ChatUser.BOTTOM_USER.name)
            } else {
                replace(binding.topFragment.id, ChatFragment(), ChatUser.TOP_USER.name)
                replace(binding.bottomFragment.id, ChatFragment(), ChatUser.BOTTOM_USER.name)
            }
                .commit()
        }
    }

    private fun listener() {
        binding.modesSwitch.setOnCheckedChangeListener { _, isChecked ->
            setDayNightMode(isChecked)
        }
    }

    private fun setDayNightMode(isNightModeOn: Boolean) {
        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.modesSwitch.setBackgroundResource(R.drawable.ic_nigth_to_day_mode)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}