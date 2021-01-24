package com.giz.android.yfutility

import com.giz.android.yfutility.datetime.SimpleDateFormatPattern
import com.giz.android.yfutility.datetime.calendar
import com.giz.android.yfutility.datetime.day
import com.giz.android.yfutility.datetime.hourIn12h
import com.giz.android.yfutility.datetime.hourIn24h
import com.giz.android.yfutility.datetime.timeText
import com.giz.android.yfutility.datetime.year
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * [SimpleDateFormat]类的相关测试
 * Created by GizFei on 2021/1/21
 */
class SimpleDateFormatTest {
    @Test
    fun testFormatEachUnit() {
//        val date = SimpleDateFormatPattern.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND.parse("2021-01-21 23:08:37")
        val date = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse("2021-01-21 23:08:37")!!
//        val date = SimpleDateFormatPattern.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND.parse("2021-01-03 05:07:09")

        println(SimpleDateFormat("y").format(date))
        println(SimpleDateFormat("yy").format(date))
        println(SimpleDateFormat("yyy").format(date))
        println(SimpleDateFormat("yyyy").format(date))

        println(SimpleDateFormat("M", Locale.ENGLISH).format(date))
        println(SimpleDateFormat("MM", Locale.ENGLISH).format(date))
        println(SimpleDateFormat("MMM", Locale.ENGLISH).format(date))
        println(SimpleDateFormat("MMMM", Locale.ENGLISH).format(date))
        println(SimpleDateFormat("MMMMM", Locale.ENGLISH).format(date))

        println(SimpleDateFormat("d").format(date))
        println(SimpleDateFormat("dd").format(date))
        println(SimpleDateFormat("ddd").format(date))   // 多的d补0

        println(SimpleDateFormat("h").format(date))
        println(SimpleDateFormat("hh").format(date))
        println(SimpleDateFormat("hhh").format(date))
        println(SimpleDateFormat("k").format(date))
        println(SimpleDateFormat("kk").format(date))
        println(SimpleDateFormat("kk").format(date))

        println(SimpleDateFormat("m").format(date))
        println(SimpleDateFormat("mm").format(date))
        println(SimpleDateFormat("mmm").format(date))

        println(SimpleDateFormat("s").format(date))
        println(SimpleDateFormat("ss").format(date))
        println(SimpleDateFormat("sss").format(date))
    }

    @Test
    fun testFormatYearUnit() {
        val date1 = SimpleDateFormatPattern.YEAR_LONG.parse("2021")
        val date2 = SimpleDateFormatPattern.YEAR_LONG.parse("2021")
        println(date1.calendar.year)
        println(date2.calendar.year)
    }

    @Test
    fun testFormatMonthUnit() {
        val date1 = SimpleDateFormatPattern.MONTH.parse("01")
        val date2 = SimpleDateFormatPattern.MONTH.parse("12")
        println(SimpleDateFormatPattern.MONTH_FULL.format(date1, Locale.CHINA))
        println(SimpleDateFormatPattern.MONTH_FULL.format(date2, Locale.CHINA))
        println(SimpleDateFormatPattern.MONTH_ABBR.format(date1, Locale.CHINA))
        println(SimpleDateFormatPattern.MONTH_ABBR.format(date2, Locale.CHINA))
    }

    @Test
    fun testFormatHourUnit() {
        // 12小时制
        val date1 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 00:08:37")
        println(SimpleDateFormat("dd hh aa").format(date1))
        val date2 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 01:08:37")
        println(SimpleDateFormat("dd hh aa").format(date2))
        val date3 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 12:08:37")
        println(SimpleDateFormat("dd hh aa").format(date3))
        val date4 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 13:08:37")
        println(SimpleDateFormat("dd hh aa").format(date4))
        val date5 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 23:08:37")
        println(SimpleDateFormat("dd hh aa").format(date5))
        val date6 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 24:08:37")
        println(SimpleDateFormat("dd hh aa").format(date6))

        // 大写H
        println(SimpleDateFormat("dd HH aa").format(date1))
        println(SimpleDateFormat("dd HH aa").format(date2))
        println(SimpleDateFormat("dd HH aa").format(date3))
        println(SimpleDateFormat("dd HH aa").format(date4))
        println(SimpleDateFormat("dd HH aa").format(date5))
        println(SimpleDateFormat("dd HH aa").format(date6))

        // 24小时制
        println(SimpleDateFormat("dd kk aa").format(date1))
        println(SimpleDateFormat("dd kk aa").format(date2))
        println(SimpleDateFormat("dd kk aa").format(date3))
        println(SimpleDateFormat("dd kk aa").format(date4))
        println(SimpleDateFormat("dd kk aa").format(date5))
        println(SimpleDateFormat("dd kk aa").format(date6))

        println(SimpleDateFormat("dd KK aa").format(date1))
        println(SimpleDateFormat("dd KK aa").format(date2))
        println(SimpleDateFormat("dd KK aa").format(date3))
        println(SimpleDateFormat("dd KK aa").format(date4))
        println(SimpleDateFormat("dd KK aa").format(date5))
        println(SimpleDateFormat("dd KK aa").format(date6))
    }

    @Test
    fun testFormatMinuteSecondUnit() {
        val date1 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 00:08:07")
        val date2 = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 00:27:37")
        println(SimpleDateFormat("m").format(date1))
        println(SimpleDateFormat("mm").format(date1))
        println(SimpleDateFormat("m").format(date2))
        println(SimpleDateFormat("mm").format(date2))

        println(SimpleDateFormat("s").format(date1))
        println(SimpleDateFormat("ss").format(date1))
        println(SimpleDateFormat("s").format(date2))
        println(SimpleDateFormat("ss").format(date2))
    }

    @Test
    fun testCalendarTimeZone() {
        val date = SimpleDateFormatPattern.STANDARD.parse("2021-01-21 23:08:37")
        val calendarChina = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00")).apply { timeInMillis = date.time }
        val calendarUK = Calendar.getInstance(TimeZone.getTimeZone("GMT+0:00")).apply { timeInMillis = date.time }

        println(calendarChina.time.time)
        println(calendarChina.timeText())
        println(calendarUK.time.time)
        println(calendarUK.timeText())
    }

}