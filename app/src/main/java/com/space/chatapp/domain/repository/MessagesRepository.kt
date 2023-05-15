package com.space.chatapp.domain.repository

import com.space.chatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.Flow

/**
 * The MessagesRepository interface is an abstraction of the data source
 * that provides methods for accessing and manipulating the messages in the messages table.
 * It defines two methods, getAllMessages() and insertMessage(), which retrieve all messages and insert a new message into the table, respectively.
 */
interface MessagesRepository {
    suspend fun getAllMessages(): Flow<List<MessageModel>>
    suspend fun insertMessage(messageModel: MessageModel)
}