package com.luuren.kanmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bin.baselibrary.ext.log
import com.luuren.kanmovie.db.TestRoom
import com.luuren.kanmovie.db.TestRoomDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

//    private val okHttpClient by inject<OkHttpClient>()
//    private val retrofit by inject<Retrofit>()
//    private val mainApi by inject<MainApi>()
//    private val testRoomDao by inject<TestRoomDao>()
    private val myViewModel by viewModel<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        okHttpClient.toString().log()
//        retrofit.toString().log()
//        mainApi.toString().log()

//        GlobalScope.launch {
//            Thread.currentThread().name.log()
//            testRoomDao.insert(TestRoom(1, "caiyangbingddd")).toString().log()
//            testRoomDao.queryAll().forEach {
//               "${it.id}---${it.name}".log()
//            }
//        }

        myViewModel.currentName.observe(this, Observer {
            "${Thread.currentThread().name}--$it".log()
        })

        myViewModel.getName()
        "执行下面的操作了".log()
    }
}
