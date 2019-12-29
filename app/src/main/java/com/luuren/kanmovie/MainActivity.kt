package com.luuren.kanmovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 容器activity，也是项目唯一的activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
