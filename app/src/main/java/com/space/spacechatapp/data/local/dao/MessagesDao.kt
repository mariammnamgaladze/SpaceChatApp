package com.space.spacechatapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.space.spacechatapp.data.local.entity.MessagesEntity
import kotlinx.coroutines.flow.Flow

/**
 *The MessagesDao interface is a Data Access Object (DAO) interface that provides methods for accessing and manipulating data in the messages table.
 *This interface is typically used in conjunction with Room, an SQLite object-mapping library for Android.
 **/
@Dao
interface MessagesDao {
    @Query("SELECT * FROM messages")
    fun getAll(): Flow<List<MessagesEntity>>

    @Insert
    suspend fun insertMessages(messagesEntity: MessagesEntity)
}