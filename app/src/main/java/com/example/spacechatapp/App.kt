package com.example.spacechatapp

import android.app.Application
import com.example.spacechatapp.di.databaseModule
import com.example.spacechatapp.di.repositoryModule
import com.example.spacechatapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                databaseModule, repositoryModule,
                viewModelModule
            )
        }
    }
}