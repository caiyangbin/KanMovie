package com.luuren.kanmovie

import android.app.Application
import com.luuren.libnet.app.Api
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        //开启koin
        startKoin {
            //给Koin框架添加ApplicationContext
            androidContext(this@App)
            logger(AndroidLogger())
            modules(
                module {
                    single { get<Retrofit>().create(Api::class.java) }
                }
            )
        }
    }
}