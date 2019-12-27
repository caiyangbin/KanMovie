package com.bin.baselibrary.ext

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes


/**
 * 获取String字符串
 */
fun Context.getStringEx(resId: Int): String = this.resources.getString(resId)

/**
 * 获取Color颜色值
 */
fun Context.getColorEx(resId: Int): Int = this.resources.getColor(resId)

/**
 * 获取Drawable id值
 */
fun Context.getDrwableEx(resId: Int): Drawable = resources.getDrawable(resId)


//----------屏幕尺寸----------
inline val Context.displayWidth
    get() = resources.displayMetrics.widthPixels

inline val Context.displayHeight
    get() = resources.displayMetrics.heightPixels

fun Context.inflateLayout(
    @LayoutRes layoutResId: Int, parent: ViewGroup? = null,
    attachToRoot: Boolean = false
) = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)


//----------尺寸转换----------
fun Context.dp2px(dpValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

fun Context.px2dp(pxValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun Context.sp2px(spValue: Float): Int {
    val scale = resources.displayMetrics.scaledDensity
    return (spValue * scale + 0.5f).toInt()
}

fun Context.px2sp(pxValue: Float): Int {
    val scale = resources.displayMetrics.scaledDensity
    return (pxValue / scale + 0.5f).toInt()
}