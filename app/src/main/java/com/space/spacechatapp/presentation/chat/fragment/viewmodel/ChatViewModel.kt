package com.space.spacechatapp.presentation.chat.fragment.viewmodel

import androidx.lifecycle.ViewModel
import com.space.spacechatapp.common.extension.getCurrentTime
import com.space.spacechatapp.common.extension.viewModelScope
import com.space.spacechatapp.domain.repository.MessagesRepository
import com.space.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.Flow

class ChatViewModel(private val repository: MessagesRepository) : ViewModel() {
    private fun provideMessageModel(text: String, tag: String, isOnline: Boolean) = MessageModel(
        user = tag,
        message = text,
        sentDate = getCurrentTime(),
        isOnline = isOnline
    )

    suspend fun getMessages(): Flow<List<MessageModel>> = repository.getAllMessages()
    fun sendMessages(input: String, tag: String, isOnline: Boolean) {
        viewModelScope {
            repository.insertMessage(provideMessageModel(input, tag, isOnline))
        }
    }
}
