package com.hagan.ppjoke.utils

import android.content.Context

class DisplayUtil {

    companion object {
        fun dp2px(context: Context, dpValue: Int): Int {
            val value = context.resources.displayMetrics.density * dpValue + 0.5f
            return value.toInt()
        }
    }


}