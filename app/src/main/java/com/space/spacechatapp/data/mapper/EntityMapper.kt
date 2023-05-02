package com.space.spacechatapp.data.mapper

import com.space.spacechatapp.data.local.entity.MessagesEntity
import com.space.spacechatapp.presentation.model.MessageModel

fun MessageModel.toMessagesEntity() = MessagesEntity(
    id = id,
    message = message,
    sentDate = sentDate,
    user = user
)

fun MessagesEntity.toMessageModel() = MessageModel(
    id = id,
    message = message,
    sentDate = sentDate,
    user = user
)