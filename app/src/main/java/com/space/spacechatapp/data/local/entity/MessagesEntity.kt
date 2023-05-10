package com.space.spacechatapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessagesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val message: String,
    val sentDate: Long,
    val user: String,
    val isOnline:Boolean = true
)