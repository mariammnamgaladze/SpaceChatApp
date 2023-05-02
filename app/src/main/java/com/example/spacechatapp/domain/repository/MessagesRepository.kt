package com.example.spacechatapp.domain.repository

import com.example.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.Flow

interface MessagesRepository {

    suspend fun getAll(): Flow<List<MessageModel>>

    suspend fun insertMessage(messageModel: MessageModel)
}