package com.space.spacechatapp.presentation.chat.viewmodels

import androidx.lifecycle.ViewModel
import com.space.spacechatapp.common.extension.viewModelScope
import com.space.spacechatapp.domain.repository.MessagesRepository
import com.space.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.Flow



class ChatViewModel(private val repository: MessagesRepository) : ViewModel() {

    suspend fun getMessages(): Flow<List<MessageModel>> = repository.getAllMessages()

    fun sendMessages(messageModel: MessageModel) {
        viewModelScope{
                repository.insertMessage(messageModel)
            }
        }
    }
