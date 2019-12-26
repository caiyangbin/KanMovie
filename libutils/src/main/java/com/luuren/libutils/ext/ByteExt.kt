package com.bin.baselibrary.ext

/**
 * Byte数组ext
 * create by Luuren on 2019/12/26 10:58
 */

private val HEX_CHAR = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

/**
 * byte数组转换成16进制字符串
 * create by Luuren on 2019/12/26 10:59
 */
fun ByteArray.byteArrayToHexString(): String {

    var buf = CharArray(this.size * 2)
    var a: Int
    var index = 0
    for (b in this) {
        // 使用除与取余进行转换
        a = if (b < 0) {
            256 + b
        } else {
            b.toInt()
        }
        buf[index++] = HEX_CHAR[a / 16]
        buf[index++] = HEX_CHAR[a % 16]
    }
    return String(buf)
}
