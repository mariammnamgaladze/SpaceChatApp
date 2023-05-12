package com.space.spacechatapp.data.repository

import com.space.spacechatapp.data.local.dao.MessagesDao
import com.space.spacechatapp.data.mapper.toMessageModel
import com.space.spacechatapp.data.mapper.toMessagesEntity
import com.space.spacechatapp.domain.repository.MessagesRepository
import com.space.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.map

/**
 * The MessagesRepositoryImpl class is an implementation of the MessagesRepository interface that provides the necessary database operations to retrieve and insert messages.
 * It takes an instance of the MessagesDao interface as its constructor parameter, which is used to access the messages table in the database.
 */
class MessagesRepositoryImpl(private val messagesDao: MessagesDao) : MessagesRepository {
    override suspend fun getAllMessages() = messagesDao.getAll().map { chat ->
        chat.map {
            it.toMessageModel()
        }
    }

    override suspend fun insertMessage(messageModel: MessageModel) {
        messagesDao.insertMessages(messageModel.toMessagesEntity())
    }
}