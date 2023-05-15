package com.space.chatapp.presentation.chat.fragment.viewmodel

import androidx.lifecycle.ViewModel
import com.space.chatapp.common.extension.getCurrentTime
import com.space.chatapp.common.extension.viewModelScope
import com.space.chatapp.domain.repository.MessagesRepository
import com.space.chatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.Flow

class ChatViewModel(private val repository: MessagesRepository) : ViewModel() {
    private fun provideMessageModel(text: String, userID: String, isOnline: Boolean) = MessageModel(
        user = userID,
        message = text,
        sentDate = getCurrentTime(),
        isOnline = isOnline
    )

    suspend fun getMessages(): Flow<List<MessageModel>> = repository.getAllMessages()
    fun sendMessages(input: String, userID:String, isOnline: Boolean) {
        viewModelScope {
            repository.insertMessage(provideMessageModel(input, userID, isOnline))
        }
    }
    /**
     * The filterMessages function takes a list of MessageModel objects and a user ID as input.
     * It filters the messages based on two conditions: messages sent by the specified user and messages marked as "online."
     * It returns a new list with only the messages that meet these criteria.
     */
    fun filterMessages(messages: List<MessageModel>, userID: String): List<MessageModel> {
        return messages.filter {
            it.user == userID || it.isOnline
        }
    }
}
