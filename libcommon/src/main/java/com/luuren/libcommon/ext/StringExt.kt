package com.bin.baselibrary.ext

import android.os.Environment
import android.util.Log
import java.io.File
import java.util.regex.Pattern

const val VERBOSE = 0X01
const val DEBUG = 0X02
const val INFO = 0X03
const val WARN = 0X04
const val ERROR = 0X05

/**
 * Log工具类扩展：[level]-Log等级，[tag]-Tag
 */
fun String.log(tag: String = "cyb", level: Int = INFO) {
  when (level) {
    VERBOSE -> Log.v(tag, this)
    DEBUG -> Log.d(tag, this)
    INFO -> Log.i(tag, this)
    WARN -> Log.w(tag, this)
    ERROR -> Log.e(tag, this)
  }
}

/**
 * 创建文件
 */
fun String.createFile(): File {
  val file = File(this)
  if (!file.exists()) {
    file.createNewFile()
  }
  return file
}

/**
 * 删除文件
 */
fun String.delFile(): Boolean {
  val file = File(this)
  if (file.checkFile()) {
    return false
  }
  return file.delete()
}

fun String.allFileDelete(): Boolean {
  val file = File(this)
  when {
    file.exists() && file.isFile -> return this.deleteFile()
    file.exists() && file.isDirectory -> return this.deleteDir()
  }
  return false
}

/**
 * 删除文件
 */
fun String.deleteFile(): Boolean {
  try {
    val file = File(this)
    if (file.exists() && file.isFile) {
      return file.delete()
    }
  } catch (e: Exception) {
    e.printStackTrace()
    return false
  }
  return false
}

/**
 * 删除文件夹
 */
fun String.deleteDir(): Boolean {
  return try {
    val dir = File(this)
    if (dir.exists() && dir.isDirectory) {
      dir.listFiles().forEach {
        when {
          it.isDirectory -> it.absolutePath.deleteDir()
          it.isFile -> it.delete()
        }
      }
    }
    dir.delete()
    true
  } catch (e: Exception) {
    e.printStackTrace()
    false
  }
}

/**
 * 递归删除目录下的所有文件及子目录下所有文件
 *
 * @param file
 * 将要删除的文件目录
 */
fun deleteFile(file: File): Boolean {
  if (file.exists()&&file.isDirectory) {
    val children = file.list()// 递归删除目录中的子目录下
    for (i in children!!.indices) {
      val success = deleteFile(File(file, children[i]))
      if (!success) {
        return false
      }
    }
  }
  // 目录此时为空，可以删除
  return file.delete()
}


/**
 * 获取根目录
 */
fun getRootDir(): String {
  return if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED)
    Environment.getExternalStorageDirectory().absolutePath else ""
}

/**
 * 可创建多个文件夹
 */
fun String.mkDir() {
  val dirArray = this.split("/".toRegex())
  var pathTemp = ""
  for (i in 1 until dirArray.size) {
    pathTemp = "$pathTemp/${dirArray[i]}"
    val newF = File("${dirArray[0]}$pathTemp")
    if (!newF.exists()) {
      newF.mkdir()
    }
  }
}

/**
 * 检查文件是否存在
 */
private fun File?.checkFile(): Boolean {
  return this == null || !this.exists() || !this.isDirectory
}

/**
 * 判断字符串中是否包含中文
 */
fun String.isContainChinese(): Boolean {
  val p = Pattern.compile("[\u4e00-\u9fa5]")
  val matcher = p.matcher(this)
  return matcher.find()
}

/**
 * 去掉字符串中的英文
 */
fun String.replaceEnglish(): String {
  return this.replace("[a-zA-Z]".toRegex(), "")
}