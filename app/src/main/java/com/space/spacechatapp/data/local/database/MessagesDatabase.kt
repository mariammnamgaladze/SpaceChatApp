package com.space.spacechatapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.spacechatapp.data.local.dao.MessagesDao
import com.space.spacechatapp.data.local.database.MessagesDatabase.Companion.DB_VERSION
import com.space.spacechatapp.data.local.entity.MessagesEntity

@Database(
    entities = [MessagesEntity::class],
    version = DB_VERSION, exportSchema = true
)
abstract class MessagesDatabase : RoomDatabase() {
    abstract fun messagesDao(): MessagesDao

    companion object {
        const val DB_VERSION = 4
    }
}