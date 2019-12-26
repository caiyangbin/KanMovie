package com.demo.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.alibaba.android.arouter.launcher.ARouter
import java.io.Serializable
import kotlin.collections.ArrayList

/**
 * Activity Fragment 跳转封装 Arouter跨模块
 */
object JumpUtils {

    private const val FIRSTTAG = "FIRSTTAG"

    private const val SECENDTAG = "SECENDTAG"

    private const val THIRDATG = "THIRDTAG"

    private const val FOUR = "FOUR"

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>) {
        val intent = Intent(context, toActivity)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: String) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: Int, tag2: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: String, tag2: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: String, tag2: String) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: Int, tag2: Int, tag3: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        intent.putExtra(THIRDATG, tag3)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithParceble(activity: Activity, toActivity: Class<T>, data: Parcelable) {
        val intent = Intent(activity, toActivity)
        intent.putExtra(FIRSTTAG, data)
        activity.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithParceble(activity: Context, toActivity: Class<T>, data: Parcelable, type: Int) {
        val intent = Intent(activity, toActivity)
        intent.putExtra(FIRSTTAG, data)
        intent.putExtra(SECENDTAG, type)
        activity.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithData3(context: Context, toActivity: Class<T>, tag: String, tag1: String, tag2: String) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag1)
        intent.putExtra(THIRDATG, tag2)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithSerial(activity: Activity, toActivity: Class<T>, data: Serializable) {
        val intent = Intent(activity, toActivity)
        intent.putExtra(FIRSTTAG, data)
        activity.startActivity(intent)
    }

    fun JumpActivity(path: String) {
        ARouter.getInstance().build(path).navigation()
    }

    fun JumpActivityWithParceble(path: String, data: Parcelable?) {
//    fun JumpActivityWithParceble(path: String, data: Parcelable?) {
        ARouter.getInstance().build(path).withParcelable(FIRSTTAG, data).navigation()
    }

    fun JumpActivity(path: String, tag: String?, tag2: String?) {
        ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .navigation()
    }

    fun JumpActivity(path: String, tag: String?, tag2: String?, data: Parcelable?) {
        ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .withParcelable(THIRDATG, data)
                .navigation()
    }

    fun JumpActivity(path: String, tag: String?, tag2: String?, tag3: String?) {
        ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .withString(FOUR, tag3)
                .navigation()
    }
}