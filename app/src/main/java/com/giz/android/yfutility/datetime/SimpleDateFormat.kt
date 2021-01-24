/**
 * java.text.SimpleDateFormat类的相关扩展函数、扩展属性等
 * Created by GizFei on 2021/1/21
 */

package com.giz.android.yfutility.datetime

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class SimpleDateFormatPattern(val pattern: String) {
    /**
     * 4位数年份的末尾2位。
     * 2021 -> 21
     * 1995 -> 95
     */
    YEAR_SHORT("yy"),

    /**
     * 4位数完整年份。
     * 如：2021、1995。
     */
    YEAR_LONG("yyyy"),

    /**
     * 标准年份。
     */
    YEAR(YEAR_LONG),

    /**
     * 数字月份。1-12，不补0。
     */
    MONTH_SHORT("M"),

    /**
     * 数字月份。01-12，补0
     */
    MONTH_LONG("MM"),

    /**
     * 标准月份。
     */
    MONTH(MONTH_LONG),

    /**
     * 单词缩写月份。如：一月，Jan，十二月
     */
    MONTH_ABBR("MMM"),

    /**
     * 单词全称月份。如：一月，January，十二月
     */
    MONTH_FULL("MMMM"),

    /**
     * 当月几号。1-31，不补0。
     */
    DAY_SHORT("d"),

    /**
     * 当月几号。01-31，补0。
     */
    DAY_LONG("dd"),

    /**
     * 标准日数。
     */
    DAY(DAY_LONG),

    HOUR_12h_1based_SHORT("h"),

    HOUR_12h_1based_LONG("hh"),

    HOUR_12h_0based_SHORT("K"),

    HOUR_12h_0based_LONG("KK"),

    HOUR_24h_1based_SHORT("k"),

    HOUR_24h_1based_LONG("kk"),

    HOUR_24h_0based_SHORT("H"),

    HOUR_24h_0based_LONG("HH"),

    HOUR(HOUR_12h_1based_LONG),

    MINUTE_SHORT("m"),

    MINUTE_LONG("mm"),

    SECOND_SHORT("s"),

    SECOND_LONG("ss"),

    AM_PM("a"),

    YEAR_MONTH("yyyy-MM"),
    YEAR_MONTH_DAY("yyyy-MM-dd"),

    /**
     * 最常用的标准格式：年-月-日 时:分:秒
     * 24小时制
     */
    STANDARD("yyyy-MM-dd kk:mm:ss");

    constructor(enumPattern: SimpleDateFormatPattern): this(enumPattern.pattern)

    /**
     * 将[Date]格式化成字符串。
     * @param inDate 日期
     * @param locale 地区。决定了输出字符串的语言。
     * @return 格式化日期字符串
     */
    fun format(inDate: Date, locale: Locale = Locale.getDefault()): String = SimpleDateFormat(pattern, locale).format(inDate)

    /**
     * 将字符串解析成 [Date]
     * @param locale 地区。字符串语言。
     * @return 正确解析的[Date]。如果解析错误，则返回当前时间。
     */
    fun parse(src: String, locale: Locale = Locale.getDefault()): Date = try {
        SimpleDateFormat(pattern, locale).parse(src) ?: Date()
    } catch (e: ParseException) {
        Date()
    }

    /**
     * 将字符串解析成 [Date]
     * @return 正确解析的[Date]。如果解析错误，则返回空。
     */
    fun parseOrNull(src: String, locale: Locale = Locale.getDefault()): Date? = try {
        SimpleDateFormat(pattern, locale).parse(src)
    } catch (e: ParseException) {
        null
    }
}