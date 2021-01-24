/**
 * 时间转换相关的扩展函数、扩展属性
 * Created by GizFei on 2021/1/20
 */

@file:JvmName("TimeUnitUtils")
package com.giz.android.yfutility.datetime

import java.util.concurrent.TimeUnit

/**
 * 毫秒 -> 秒
 */
fun Long.toSeconds(): Long = TimeUnit.MILLISECONDS.toSeconds(this)

/**
 * 秒 -> 毫秒
 */
fun Long.toMillis(): Long = TimeUnit.SECONDS.toMillis(this)