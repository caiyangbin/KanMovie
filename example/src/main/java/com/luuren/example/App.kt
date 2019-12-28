package com.luuren.example

import android.app.Application
import android.view.View
import androidx.navigation.Navigation
import com.luuren.example.main.HomeViewModel
import com.luuren.example.motionlayout.MotionViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //给koin框架添加ApplicationContext
            androidContext(this@App)
            logger(AndroidLogger())
            modules(
                module {
                    viewModel { HomeViewModel() }
                    viewModel { MotionViewModel() }
                    single { (view: View)->Navigation.findNavController(view) }
                }
            )
        }
    }
}