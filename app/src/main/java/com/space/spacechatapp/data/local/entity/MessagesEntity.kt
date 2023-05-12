package com.space.spacechatapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The MessagesEntity class is a data class that represents a row in the messages table.
 * It is annotated with the @Entity annotation,
 * which is used to specify the name of the table and the primary key for the table.
 */
@Entity(tableName = "messages")
data class MessagesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val message: String,
    val sentDate: Long,
    val user: String,
    val isOnline:Boolean = true
)