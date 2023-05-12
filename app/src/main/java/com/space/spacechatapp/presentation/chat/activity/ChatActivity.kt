package com.space.spacechatapp.presentation.chat.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.space.spacechatapp.common.extension.viewBinding
import com.space.spacechatapp.databinding.ActivityChatBinding
import com.space.spacechatapp.presentation.chat.activity.viewmodel.ActivityViewModel
import com.space.spacechatapp.presentation.chat.fragment.ChatFragmentFirst
import com.space.spacechatapp.presentation.chat.fragment.ChatFragmentSecond

class ChatActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityChatBinding::inflate)
    private val viewModel: ActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setUpFragments()
        }
        setListener()
        setObservers()
    }

    private fun setUpFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.topFragment.id, ChatFragmentFirst())
            replace(binding.bottomFragment.id, ChatFragmentSecond())
        }
            .commit()
    }

    private fun setObservers() {
        viewModel.themeLiveData.observe(this, Observer { theme ->
            AppCompatDelegate.setDefaultNightMode(theme)
        })
        viewModel.backgroundLiveData.observe(this, Observer { background ->
            binding.modesSwitch.setBackgroundResource(background)
        })
    }

    private fun setListener() {
        binding.modesSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setDayNightMode(isChecked)
        }
    }
}