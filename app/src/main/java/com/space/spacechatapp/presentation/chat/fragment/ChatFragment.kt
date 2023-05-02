package com.space.spacechatapp.presentation.chat.fragment

import com.space.spacechatapp.R
import com.space.spacechatapp.common.extension.getCurrentTime
import com.space.spacechatapp.common.extension.lifecycleScope
import com.space.spacechatapp.common.extension.viewBinding
import com.space.spacechatapp.databinding.FragmentChatBinding
import com.space.spacechatapp.presentation.adapter.MessageAdapter
import com.space.spacechatapp.presentation.base.BaseFragment
import com.space.spacechatapp.presentation.chat.viewmodels.ChatViewModel
import com.space.spacechatapp.presentation.model.ChatUser
import com.space.spacechatapp.presentation.model.MessageModel
import kotlin.reflect.KClass


class ChatFragment : BaseFragment<ChatViewModel>(R.layout.fragment_chat) {
    private val binding by viewBinding(FragmentChatBinding::bind)
    override val viewModelClass: KClass<ChatViewModel>
        get() = ChatViewModel::class
    private val adapter by lazy {
        MessageAdapter(ChatUser.valueOf(tag!!))
    }

    override fun onBind(viewModel: ChatViewModel) {
        initRecycler()
        getMessages(viewModel)
        listener(viewModel)
    }

    private fun initRecycler() {
        binding.chatRecyclerView.adapter = adapter
    }

    private fun listener(viewModel: ChatViewModel) {
        binding.sentButton.setOnClickListener {
            sendMessage(viewModel)
        }
    }

    private fun provideMessageModel(text: String) = MessageModel(
        user = ChatUser.valueOf(tag.toString()),
        message = text,
        sentDate = getCurrentTime()
    )

    private fun getMessages(viewModel: ChatViewModel) {
        lifecycleScope {
            viewModel.getMessages().collect {
                adapter.submitList(it)
            }
        }
    }

    private fun sendMessage(viewModel: ChatViewModel) {
        viewModel.sendMessages(provideMessageModel(binding.messageEditText.text.toString()))
        binding.messageEditText.text?.clear()
    }
}