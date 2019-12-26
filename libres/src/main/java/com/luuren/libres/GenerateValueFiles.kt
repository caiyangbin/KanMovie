package com.luuren.libres

import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.PrintWriter

/** {0}-高度 {1}-宽度 */
private const val VALUE_TEMPLATE = "values-{0}x{1}"
/** 可自由添加分辨率 */
private const val SUPPORT_DIMESION = "1920,1080;2560,1440;3840,2160;1280,720;"

/**
 * 适配不同分辨率values-dimens的工具类
 * create by Luuren on 2019/12/25 17:00
 */
class GenerateValueFiles(private var baseW: Int, private var baseH: Int) {

    private val mDirStr = "./libres/src/main/res"
    private val mWTemplate = "<dimen name=\"x{0}\" tools:ignore=\"PxUsage\">{1}px</dimen>\n"
    private val mHTemplate = "<dimen name=\"y{0}\" tools:ignore=\"PxUsage\">{1}px</dimen>\n"
    private var mSupportStr = SUPPORT_DIMESION

    init {
        mSupportStr = SUPPORT_DIMESION
        if (!mSupportStr.contains("$baseW,$baseH")) {
            mSupportStr += "$baseW,$baseH;"
        }
    }

    fun generate() {
        val supportStrs = mSupportStr.split(";")
        supportStrs.forEach {
            if (it.isNotEmpty()) {
                val split = it.split(",")
                val w = Integer.parseInt(split[0])
                val h = Integer.parseInt(split[1])
                generateXmlFile(w, h)
            }
        }
    }

    private fun change(a: Float): Float {
        val temp = (a * 100).toInt()
        return temp / 100f
    }

    private fun generateXmlFile(w: Int, h: Int) {

        val sbForWidth = StringBuffer()
        sbForWidth.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        sbForWidth.append("<resources xmlns:tools=\"http://schemas.android.com/tools\">\n")
        val cellW = w * 1.0f / baseW

        println("width : $w,$baseW,$cellW")

        for (i in 1 until baseW) {
            sbForWidth.append(mWTemplate.replace("{0}", i.toString()).replace("{1}", change(cellW * i).toString()))
        }
        sbForWidth.append(mWTemplate.replace("{0}", baseW.toString()).replace("{1}", w.toString()))
        sbForWidth.append("</resources>")

        val sbForHeight = StringBuffer()
        sbForHeight.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        sbForHeight.append("<resources xmlns:tools=\"http://schemas.android.com/tools\">\n")
        val cellH = h * 1.0f / baseH

        println("height : $h,$baseH,$cellH")

        for (i in 1 until baseH) {
            sbForHeight.append(mHTemplate.replace("{0}", i.toString()).replace("{1}", change(cellH * i).toString()))
        }
        sbForHeight.append(mHTemplate.replace("{0}", baseH.toString()).replace("{1}", h.toString()))
        sbForHeight.append("</resources>")

        val fileDir = File(
            mDirStr + File.separator
                    + VALUE_TEMPLATE.replace("{0}", w.toString()).replace("{1}", h.toString())
        )
        fileDir.mkdir()

        val valueXFile = File("./libres/src/main/res/values", "dimens_x.xml")
        val valueYFile = File("./libres/src/main/res/values", "dimens_y.xml")

        val layXFile = File(fileDir.absolutePath, "dimens_x.xml")
        val layYFile = File(fileDir.absolutePath, "dimens_y.xml")

        try {
            var pw = PrintWriter(FileOutputStream(layXFile))
            pw.print(sbForWidth.toString())
            pw.close()
            if (cellW == 1f) {
                pw = PrintWriter(FileOutputStream(valueXFile))
                pw.print(sbForWidth.toString())
                pw.close()
            }
            pw = PrintWriter(FileOutputStream(layYFile))
            pw.print(sbForHeight.toString())
            pw.close()
            if (cellH == 1f) {
                pw = PrintWriter(FileOutputStream(valueYFile))
                pw.print(sbForHeight.toString())
                pw.close()
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }
}

fun main(args: Array<String>) {
    //设计稿基于的分辨率
    val baseW = 1080
    val baseH = 1920
    GenerateValueFiles(baseW, baseH).generate()
}