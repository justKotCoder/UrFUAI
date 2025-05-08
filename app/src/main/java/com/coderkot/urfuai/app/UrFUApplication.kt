package com.coderkot.urfuai.app

import android.app.Application
import com.coderkot.chat.di.chatModule
import com.coderkot.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UrFUApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@UrFUApplication)
            modules(
                homeModule,
                chatModule
            )
        }
    }
}