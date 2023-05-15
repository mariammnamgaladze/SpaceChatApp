package com.space.chatapp.data.mapper

import com.space.chatapp.data.local.entity.MessagesEntity
import com.space.chatapp.presentation.model.MessageModel

fun MessageModel.toMessagesEntity() = MessagesEntity(
    id = id,
    message = message,
    sentDate = sentDate,
    user = user,
    isOnline = isOnline
)

fun MessagesEntity.toMessageModel() = MessageModel(
    id = id,
    message = message,
    sentDate = sentDate,
    user = user,
    isOnline = isOnline
)