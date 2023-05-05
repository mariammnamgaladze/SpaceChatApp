package com.space.spacechatapp.domain.repository

import com.space.spacechatapp.presentation.model.MessageModel
import kotlinx.coroutines.flow.Flow

interface MessagesRepository {
    suspend fun getAllMessages(): Flow<List<MessageModel>>
    suspend fun insertMessage(messageModel: MessageModel)
}