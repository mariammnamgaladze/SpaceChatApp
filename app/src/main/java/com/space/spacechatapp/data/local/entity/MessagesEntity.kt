package com.space.spacechatapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.space.spacechatapp.presentation.model.ChatUser

@Entity(tableName = "messages")
data class MessagesEntity (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int? = null,

        @ColumnInfo(name = "message")
        val message: String,

        @ColumnInfo(name = "sent_date")
        val sentDate: Long,

        @ColumnInfo(name = "chat_user")
        val user: ChatUser,
        )