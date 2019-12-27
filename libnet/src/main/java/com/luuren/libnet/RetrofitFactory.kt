package com.luuren.libnet.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.luuren.libnet.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


fun getRetrofit(
    API_BASE_URL: String,
    okHttpClient: OkHttpClient = getOkHttpClient()
): Retrofit = Retrofit.Builder()
    .baseUrl(API_BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(dateGson))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

fun getOkHttpClient(
    customInterceptor: Interceptor = DefaultInterceptor()
): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(customInterceptor)
    .addInterceptor(initLogInterceptor())
    .retryOnConnectionFailure(true)//失败重试一次 比较关键
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .build()

private val dateGson: Gson
    get() = GsonBuilder()
        //如果不设置serializeNulls,序列化时默认忽略NULL
        .serializeNulls()
        //使打印的json字符串更美观，如果不设置，打印出来的字符串不分行
        .setPrettyPrinting()
        .create()

private fun initLogInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return interceptor
}

class DefaultInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response? {
        val random = Random()
        val newRequest = chain.request().newBuilder()
            .addHeader("Content_Type", "application/json")
            .addHeader("charset", "UTF-8")
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"
            )
            .addHeader(
                "X-Forwarded-For",
                "${random.nextInt(255)}.${random.nextInt(255)}.${random.nextInt(255)}.${random.nextInt(255)}"
            ).build()
        return chain.proceed(newRequest)
    }
}




