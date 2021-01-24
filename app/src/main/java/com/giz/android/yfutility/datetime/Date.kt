/**
 * Date相关的扩展函数、扩展属性等
 * Created by GizFei on 2021/1/24
 */

package com.giz.android.yfutility.datetime

import java.util.Calendar
import java.util.Date
import java.util.TimeZone

/**
 * 获取时间为[Date]的[Calendar]
 */
val Date.calendar: Calendar get() = Calendar.getInstance().also { it.time = this }

/**
 * 获取时间为[Date]的[Calendar]
 * @param timeZone 时区
 */
fun Date.toCalendar(timeZone: TimeZone = TimeZone.getDefault()): Calendar
        = Calendar.getInstance(timeZone).apply { time = this@toCalendar }