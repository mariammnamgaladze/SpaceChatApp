package com.space.spacechatapp

import android.app.Application
import com.space.spacechatapp.di.databaseModule
import com.space.spacechatapp.di.repositoryModule
import com.space.spacechatapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
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