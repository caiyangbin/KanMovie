package com.luuren.kanmovie

import android.app.Application
import com.luuren.kanmovie.db.TestRoomDatabase
import com.luuren.libnet.app.getOkHttpClient
import com.luuren.libnet.app.getRetrofit
import okhttp3.Call
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        //开启koin
        startKoin {
            //给koin框架添加ApplicationContext
            androidContext(this@App)
            logger(AndroidLogger())
            modules(
                module {
//                    single { getOkHttpClient() }
//                    single { getRetrofit("http://www.baidu.com") }
//                    single { get<Retrofit>().create(MainApi::class.java) }
//                    single { TestRoomDatabase.getInstance(androidContext()) }
//                    single { get<TestRoomDatabase>().getTestRoomDao() }
                    viewModel { MyViewModel() }
                }
            )
        }
    }
}