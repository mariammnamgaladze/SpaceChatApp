package com.space.spacechatapp.presentation.chat.fragment

import com.space.spacechatapp.R
import com.space.spacechatapp.common.extension.isNetworkAvailable
import com.space.spacechatapp.common.extension.lifecycleScope
import com.space.spacechatapp.common.extension.viewBinding
import com.space.spacechatapp.databinding.FragmentChatBinding
import com.space.spacechatapp.presentation.adapter.MessageAdapter
import com.space.spacechatapp.presentation.base.BaseFragment
import com.space.spacechatapp.presentation.chat.fragment.viewmodel.ChatViewModel
import com.space.spacechatapp.presentation.model.MessageModel
import kotlin.reflect.KClass


class ChatFragment : BaseFragment<ChatViewModel>(R.layout.fragment_chat) {
    private val binding by viewBinding(FragmentChatBinding::bind)
    override val viewModelClass: KClass<ChatViewModel>
        get() = ChatViewModel::class
    private val adapter by lazy {
        MessageAdapter(adapterListener)
    }

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

    private fun filterMessages(messages: List<MessageModel>): List<MessageModel> {
        return messages.filter {
            it.user == adapterListener.invoke() || it.isOnline
        }
    }

    private fun getMessages(viewModel: ChatViewModel) {
        lifecycleScope {
            viewModel.getMessages().collect {
                adapter.submitList(filterMessages(it))
            }
        }
    }

    private fun sendMessage(viewModel: ChatViewModel) {
        viewModel.sendMessages(
            binding.messageEditText.text.toString(),
            tag.toString(),
            requireContext().isNetworkAvailable()
        )
        binding.messageEditText.text?.clear()
    }
}