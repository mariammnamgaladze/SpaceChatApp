package com.example.spacechatapp.presentation.chat.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacechatapp.domain.repository.MessagesRepository
import com.example.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ChatViewModel(private val repository: MessagesRepository) : ViewModel() {

    suspend fun getMessages(): Flow<List<MessageModel>> = repository.getAll()

    fun sendMessages(messageModel: MessageModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertMessage(messageModel)
            }
        }
    }
}