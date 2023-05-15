package com.space.chatapp

import android.app.Application
import com.space.chatapp.di.databaseModule
import com.space.chatapp.di.repositoryModule
import com.space.chatapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ChatApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ChatApp)
            modules(
                databaseModule, repositoryModule,
                viewModelModule
            )
        }
    }
}