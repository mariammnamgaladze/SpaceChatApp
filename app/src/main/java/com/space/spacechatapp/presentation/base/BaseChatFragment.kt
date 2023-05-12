package com.space.spacechatapp.presentation.base

import com.space.spacechatapp.R
import com.space.spacechatapp.common.extension.isNetworkAvailable
import com.space.spacechatapp.common.extension.lifecycleScope
import com.space.spacechatapp.common.extension.viewBinding
import com.space.spacechatapp.databinding.FragmentChatBinding
import com.space.spacechatapp.presentation.adapter.AdapterListener
import com.space.spacechatapp.presentation.adapter.MessageAdapter
import com.space.spacechatapp.presentation.chat.fragment.viewmodel.ChatViewModel
import kotlin.reflect.KClass

/**
 * The BaseChatFragment class is an open class that extends the BaseFragment class and is used as a base class for fragments that display chat messages.
 */
open class BaseChatFragment() : BaseFragment<ChatViewModel>() {
    private val binding by viewBinding(FragmentChatBinding::bind)
    override val viewModelClass: KClass<ChatViewModel>
        get() = ChatViewModel::class
    private val adapter by lazy {
        MessageAdapter(listener)
    }
    private val listener = object : AdapterListener {
        override fun getUserId(): String = userID()
    }

    protected open fun userID(): String = userID()

    override val layout: Int
        get() = R.layout.fragment_chat

    override fun onBind(viewModel: ChatViewModel) {
        initRecycler(viewModel)
        getMessages(viewModel)
        listener(viewModel)
    }

    private fun initRecycler(viewModel: ChatViewModel) {
        binding.chatRecyclerView.adapter = adapter
        getMessages(viewModel)
    }

    private fun listener(viewModel: ChatViewModel) {
        binding.sentButton.setOnClickListener {
            sendMessage(viewModel)
        }
    }

    private fun getMessages(viewModel: ChatViewModel) {
        lifecycleScope {
            viewModel.getMessages().collect {
                adapter.submitList(viewModel.filterMessages(it, userID()))
            }
        }
    }

    private fun sendMessage(viewModel: ChatViewModel) {
        viewModel.sendMessages(
            binding.messageEditText.text.toString(), userID(),
            requireContext().isNetworkAvailable()
        )
        binding.messageEditText.text?.clear()
    }
}