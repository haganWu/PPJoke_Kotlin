package com.hagan.libcommon

import android.annotation.SuppressLint
import android.app.Application

/**
 * @author HaganWu
 * @description 全局获取Application对象
 * @fileName AppGlobals.kt
 * @date 1/9/22-7:47 PM
 */
class AppGlobals {

    companion object {

        private var sApplication: Application? = null

        @SuppressLint("DiscouragedPrivateApi")
        fun getApplication(): Application {
            if (sApplication == null) {
                val method = Class.forName("android.app.ActivityThread")
                    .getDeclaredMethod("currentApplication")
                sApplication = method.invoke(null) as Application
            }

            return sApplication!!
        }


    }
}