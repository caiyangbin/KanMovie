package com.luuren.kanmovie

import android.app.Application
import com.luuren.kanmovie.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        //开启koin
        startKoin {
            //给koin框架添加ApplicationContext
            androidContext(this@App)
            logger(AndroidLogger())
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}