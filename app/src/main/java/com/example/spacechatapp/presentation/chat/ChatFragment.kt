package com.example.spacechatapp.presentation.chat


import androidx.lifecycle.lifecycleScope
import com.example.spacechatapp.databinding.FragmentChatBinding
import com.example.spacechatapp.presentation.adapter.MessageAdapter
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflate
import com.example.spacechatapp.presentation.model.ChatUser
import com.example.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.launch
import kotlin.reflect.KClass


class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    override val viewModelClass: KClass<ChatViewModel>
        get() = ChatViewModel::class

    override fun inflate(): Inflate<FragmentChatBinding> {
        return FragmentChatBinding::inflate
    }

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
        sentDate = 1300
    )



    private fun getMessages(viewModel: ChatViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
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