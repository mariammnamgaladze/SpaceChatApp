package com.space.chatapp.presentation.model

data class MessageModel(
    val id: Int? = null,
    val message: String,
    val sentDate: Long,
    val user: String,
    val isOnline:Boolean = true
)
