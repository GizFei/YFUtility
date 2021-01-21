/**
 * 时间转换相关的扩展函数、扩展属性
 * Created by GizFei on 2021/1/20
 */

@file:JvmName("TimeUnitUtils")
package com.giz.android.yfutility.datetime

import java.util.concurrent.TimeUnit

/**
 * 表示秒数的数据类
 */
data class Seconds(val value: Long)

/**
 * 表示毫秒数的数据类
 */
data class MilliSeconds(val value: Long)

/**
 * 表示一个数值的单位是秒
 */
val Long.sec get() = Seconds(this)

/**
 * 表示一个数值的单位是毫秒
 */
val Long.ms get() = MilliSeconds(this)

/**
 * 毫秒 -> 秒
 */
fun MilliSeconds.toSeconds(): Long = TimeUnit.MILLISECONDS.toSeconds(this.value)

/**
 * 秒 -> 毫秒
 */
fun Seconds.toMillis(): Long = TimeUnit.SECONDS.toMillis(this.value)