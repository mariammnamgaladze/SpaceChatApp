package com.example.spacechatapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.lifecycle.Observer
import com.example.spacechatapp.R
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.chat.fragment.ChatFragment
import com.example.spacechatapp.presentation.chat.viewmodels.MainViewModel
import com.example.spacechatapp.presentation.model.ChatUser

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFragments(savedInstanceState)
        setListener()
        observers()
    }

    private fun setUpFragments(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction().apply {
            if (savedInstanceState == null) {
                add(binding.topFragment.id, ChatFragment(), ChatUser.TOP.name)
                add(binding.bottomFragment.id, ChatFragment(), ChatUser.BOTTOM.name)
            } else {
                replace(binding.topFragment.id, ChatFragment(), ChatUser.TOP.name)
                replace(binding.bottomFragment.id, ChatFragment(), ChatUser.BOTTOM.name)
            }
                .commit()
        }
    }

    private fun observers() {
        viewModel.themeLiveData.observe(this, Observer { theme ->
            AppCompatDelegate.setDefaultNightMode(theme)
        })
        viewModel.backgroundLiveData.observe(this, Observer { background ->
            binding.modesSwitch.setBackgroundResource(background)
        })
    }

    private fun setListener() {
        binding.modesSwitch.setOnCheckedChangeListener { _, isChecked ->
            with(viewModel) {
                setTheme(isChecked, MODE_NIGHT_YES)
                setBackground(isChecked, R.drawable.ic_nigth_to_day_mode)
            }
        }
        binding.modesSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setDayNightMode(isChecked)
        }
    }
}