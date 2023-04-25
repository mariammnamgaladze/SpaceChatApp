package com.example.spacechatapp.presentation.model

data class MessageModel(
    val id: Int?,
    val message: String,
    val sentDate: Long,
    val user: ChatUser,
)
