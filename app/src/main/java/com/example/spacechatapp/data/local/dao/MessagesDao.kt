package com.example.spacechatapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.spacechatapp.data.local.entity.MessagesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MessagesDao {

    @Query("SELECT * FROM messages")
    fun getAll(): Flow<List<MessagesEntity>>

    @Insert
    suspend fun insertMessages(vararg messagesEntity: MessagesEntity)

}