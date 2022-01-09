package com.hagan.libcommon.utils

import android.util.Log
import com.hagan.libcommon.BuildConfig

/**
 * @author HaganWu
 * @description 日志管理类
 * @fileName L.kt
 * @date 12/14/21-7:37 PM
 */
object L {

    private const val TAG: String = "hagan"

    fun d(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.d(TAG, it)
            }
        }
    }

    fun i(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.i(TAG, it)
            }
        }
    }

    fun e(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.e(TAG, it)
            }
        }
    }
}