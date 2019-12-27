package com.luuren.movieposter.ext

import java.util.*
import kotlin.collections.HashMap

/**
 * Collection相关的ext
 * create by Luuren on 2019/12/26 10:59
 */

fun <T> Collection<T>.getDeleteElements(newCollection: Collection<T>):Collection<T>{

  val result = LinkedList<T>()
  val map = HashMap<T,Int>(newCollection.size)

  newCollection.forEach {
    map[it] = 1
  }
  this.forEach {
    if(!map.containsKey(it)){
      result.add(it)
    }
  }
  return result
}

fun <T> Collection<T>.getAddElements(newCollection: Collection<T>):Collection<T>{

  val result = LinkedList<T>()
  val map = HashMap<T,Int>(this.size)

  this.forEach {
    map[it] = 1
  }

  newCollection.forEach {
    if(!map.containsKey(it)){
      result.add(it)
    }
  }
  return result
}