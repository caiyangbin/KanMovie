package com.bin.baselibrary.ext

import android.annotation.SuppressLint
import java.text.SimpleDateFormat


/**
 * 通用扩展
 * Create at 2018/9/7--10:05 by Luuren
 */


/**
 * 设置系统属性
 */
@SuppressLint("PrivateApi")
fun getProperty(key: String, defaultValue: String): String {
    var value: String = defaultValue
    try {
        val clazz = Class.forName("android.os.SystemProperties")
        val get = clazz.getMethod("get", String::class.java, String::class.java)
        value = get.invoke(clazz, key, value) as String
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        return value
    }
}

/**
 * 获取系统属性
 */
@SuppressLint("PrivateApi")
fun setProperty(key: String, value: String) {
    try {
        val clazz = Class.forName("android.os.SystemProperties")
        val set = clazz.getMethod("set", String::class.java, String::class.java)
        set.invoke(clazz, key, value)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 获取当前时间
 */
@SuppressLint("SimpleDateFormat")
fun geCuurentTimeString(): String {
    val time = System.currentTimeMillis()
    //设置日期格式
    val df = SimpleDateFormat("MM-dd HH:mm:ss:SSS")
    return df.format(time)
}










