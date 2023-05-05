package com.space.spacechatapp.presentation.model

data class MessageModel(
    val id: Int? = null,
    val message: String,
    val sentDate: Long,
    val user: String,
)
