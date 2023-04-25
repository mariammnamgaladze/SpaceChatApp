package com.example.spacechatapp.presentation.chat


import androidx.fragment.app.viewModels
import com.example.spacechatapp.databinding.FragmentChatBinding
import com.example.spacechatapp.presentation.adapter.MessageAdapter
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflate
import com.example.spacechatapp.presentation.model.ChatUser

class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    override val viewModel by viewModels<ChatViewModel>()
    override fun inflate(): Inflate<FragmentChatBinding> {
        return FragmentChatBinding::inflate
    }

    private val adapter by lazy {
        MessageAdapter(ChatUser.valueOf(tag!!))
    }

    override fun onBind(viewModel: ChatViewModel) {
        initRecycler(viewModel)
    }

    private fun initRecycler(viewModel: ChatViewModel) {
        binding.recyclerView.adapter = adapter
    }


}