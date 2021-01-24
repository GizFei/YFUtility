package com.giz.android.yfutility

import com.giz.android.yfutility.datetime.date
import com.giz.android.yfutility.datetime.day
import com.giz.android.yfutility.datetime.dayOfWeek
import com.giz.android.yfutility.datetime.dayOfYear
import com.giz.android.yfutility.datetime.hourIn12h
import com.giz.android.yfutility.datetime.hourIn24h
import com.giz.android.yfutility.datetime.millisecond
import com.giz.android.yfutility.datetime.minute
import com.giz.android.yfutility.datetime.month
import com.giz.android.yfutility.datetime.monthActual
import com.giz.android.yfutility.datetime.second
import com.giz.android.yfutility.datetime.weekOfMonth
import com.giz.android.yfutility.datetime.weekOfYear
import com.giz.android.yfutility.datetime.year
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.TimeZone

/**
 * Calendar.kt测试
 * Created by GizFei on 2021/1/21
 */
class CalendarKtTest {
    /**
     * 测试获取年月日等属性
     */
    @Test
    fun testCalendarGetters1() {
        val today = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2021-01-21 21:50:21")
        val calendar = Calendar.getInstance().apply { time = today!! }
        println("日期：${today?.toString()}")

        assertEquals(calendar.year, 2021)
        assertEquals(calendar.month, Calendar.JANUARY)
        assertEquals(calendar.monthActual, 1)
        assertEquals(calendar.day, 21)
        assertEquals(calendar.date, 21)
        assertEquals(calendar.hourIn12h, 9)
        assertEquals(calendar.hourIn24h, 21)
        assertEquals(calendar.minute, 50)
        assertEquals(calendar.second, 21)
        assertEquals(calendar.millisecond, 0)
        assertEquals(calendar.dayOfWeek, Calendar.THURSDAY)
        assertEquals(calendar.dayOfYear, 21)
        assertEquals(calendar.weekOfMonth, 4)
        assertEquals(calendar.weekOfYear, 4)
    }

    @Test
    fun testCalendarGetters2() {
        val today = SimpleDateFormat("yyyy-MM-dd kk:mm:ss").parse("2021-02-17 12:50:21")
        val calendar = Calendar.getInstance().apply { time = today!! }
        println("日期：${calendar.time}")

        assertEquals(calendar.year, 2021)
        assertEquals(calendar.month, Calendar.FEBRUARY)
        assertEquals(calendar.monthActual, 2)
        assertEquals(calendar.day, 17)
        assertEquals(calendar.date, 17)
        assertEquals(calendar.hourIn12h, 0)
        assertEquals(calendar.hourIn24h, 12)
        assertEquals(calendar.minute, 50)
        assertEquals(calendar.second, 21)
        assertEquals(calendar.millisecond, 0)
        assertEquals(calendar.dayOfWeek, Calendar.WEDNESDAY)
        assertEquals(calendar.dayOfYear, 48)
        assertEquals(calendar.weekOfMonth, 3)
        assertEquals(calendar.weekOfYear, 8)
    }

}