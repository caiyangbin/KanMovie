package com.luuren.movieposter.ext

/**
 * @author Luuren
 * @date 2019/5/15-09:29
 */


fun <T> ArrayList<T>?.isNotNullorEmpty(): Boolean {
  return this != null && this.size > 0
}