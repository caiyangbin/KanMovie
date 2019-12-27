package com.bin.baselibrary.ext

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.view.ViewGroup

/**
 * View.VISIBLE
 */
fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

/**
 * if(xxx) View.VISIBLE
 */
inline fun View.showIf(isShow: () -> Boolean): View {
    if (visibility != View.VISIBLE && isShow.invoke()) {
        visibility = View.VISIBLE
    }
    return this
}

/**
 * View.INVISIBLE
 */
fun View.hide(): View {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
    return this
}

/**
 * if(xxx) View.INVISIBLE
 */
inline fun View.hideIf(isHide: () -> Boolean): View {
    if (visibility != View.INVISIBLE && isHide.invoke()) {
        visibility = View.INVISIBLE
    }
    return this
}

/**
 * View.GONE
 */
fun View.remove(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}


/**
 * if(xxx) View.GONE
 */
inline fun View.removeIf(isGone: () -> Boolean): View {
    if (visibility != View.GONE && isGone.invoke()) {
        visibility = View.GONE
    }
    return this
}

/**
 * View 转 bitmap
 */
fun View.view2Bitmap(): Bitmap {
    val ret = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(ret)
    val bgDrawable = this.background
    bgDrawable?.draw(canvas) ?: canvas.drawColor(Color.WHITE)
    this.draw(canvas)
    return ret
}

//-----扩展属性-----

var View.bottomMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = value
    }


var View.topMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).topMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).topMargin = value
    }


var View.rightMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).rightMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).rightMargin = value
    }

var View.leftMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).leftMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).leftMargin = value
    }

