package com.example.spacechatapp.data.mapper

import com.example.spacechatapp.data.local.entity.MessagesEntity
import com.example.spacechatapp.presentation.model.MessageModel

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