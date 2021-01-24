/**
 * Intent相关的扩展函数、扩展属性等
 * Created by GizFei on 2021/1/24
 */
package com.giz.android.yfutility.components

import android.content.Intent
import android.os.Bundle

/**
 * 为Intent添加Bundle数据
 * @param data 存入Bundle中的数据
 */
fun Intent.bundle(data: Bundle.() -> Unit) {
    this.putExtras(Bundle().apply(data))
}