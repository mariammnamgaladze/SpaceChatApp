package com.space.spacechatapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.spacechatapp.data.local.dao.MessagesDao
import com.space.spacechatapp.data.local.database.MessagesDatabase.Companion.DB_VERSION
import com.space.spacechatapp.data.local.entity.MessagesEntity

/**
 * The MessagesDatabase class is an abstract class that extends the RoomDatabase class,
 * which is an SQLite object-mapping library for Android.
 * It provides methods for accessing and manipulating the messages table.
 */
@Database(
    entities = [MessagesEntity::class],
    version = DB_VERSION, exportSchema = true
)
abstract class MessagesDatabase : RoomDatabase() {
    abstract fun messagesDao(): MessagesDao

    companion object {
        const val DB_VERSION = 6
    }
}