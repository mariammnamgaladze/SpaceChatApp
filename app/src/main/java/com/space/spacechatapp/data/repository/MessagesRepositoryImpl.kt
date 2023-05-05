package com.space.spacechatapp.data.repository

import com.space.spacechatapp.data.local.dao.MessagesDao
import com.space.spacechatapp.data.mapper.toMessageModel
import com.space.spacechatapp.data.mapper.toMessagesEntity
import com.space.spacechatapp.domain.repository.MessagesRepository
import com.space.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.map
class MessagesRepositoryImpl(private val messagesDao: MessagesDao) : MessagesRepository {


    override suspend fun getAllMessages()= messagesDao.getAll().map { chat ->
        chat.map {
            it.toMessageModel()
        }
    }

    override suspend fun insertMessage(messageModel: MessageModel) {
        messagesDao.insertMessages(messageModel.toMessagesEntity())
    }
}