package com.luuren.libimageloader.app

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade

/**
 * 处理图片显示
 * create by Luuren on 2019/12/26 13:27
 */

fun ImageView.loadImage(url:String){
    Glide.with(this.context)
        .asBitmap()
        .load(url)
        .transition(withCrossFade())
        .into(this)
}