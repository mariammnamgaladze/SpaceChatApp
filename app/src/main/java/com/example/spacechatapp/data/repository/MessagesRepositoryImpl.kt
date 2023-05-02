package com.example.spacechatapp.data.repository

import com.example.spacechatapp.data.local.dao.MessagesDao
import com.example.spacechatapp.data.mapper.toMessageModel
import com.example.spacechatapp.data.mapper.toMessagesEntity
import com.example.spacechatapp.domain.repository.MessagesRepository
import com.example.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.map
class MessagesRepositoryImpl(private val messagesDao: MessagesDao) : MessagesRepository {


    override suspend fun getAll()= messagesDao.getAll().map {chat ->
        chat.map {
            it.toMessageModel()
        }
    }

    override suspend fun insertMessage(messageModel: MessageModel) {
        messagesDao.insertMessages(messageModel.toMessagesEntity())
    }
}