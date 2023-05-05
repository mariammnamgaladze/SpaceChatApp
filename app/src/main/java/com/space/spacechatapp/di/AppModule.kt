package com.space.spacechatapp.di

import android.content.Context
import androidx.room.Room
import com.space.spacechatapp.data.local.database.MessagesDatabase
import com.space.spacechatapp.data.repository.MessagesRepositoryImpl
import com.space.spacechatapp.domain.repository.MessagesRepository
import com.space.spacechatapp.presentation.chat.fragment.viewmodel.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private fun provideMessagesDatabase(context: Context): MessagesDatabase {
    return Room.databaseBuilder(
        context,
        MessagesDatabase::class.java,
        "messages"
    )
        .fallbackToDestructiveMigration()
        .build()
}

private fun provideDao(database: MessagesDatabase) = database.messagesDao()
val databaseModule = module {
    single { provideMessagesDatabase(get()) }
    single { provideDao(get()) }
}
val repositoryModule = module {
    single<MessagesRepository> { MessagesRepositoryImpl(get()) }
}
val viewModelModule = module {
    viewModel {
        ChatViewModel(get())
    }
}





