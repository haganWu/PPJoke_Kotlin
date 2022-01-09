package com.hagan.ppjoke.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hagan.libcommon.AppGlobals
import com.hagan.ppjoke.model.BottomBar
import com.hagan.ppjoke.model.Destination
import java.util.HashMap

object AppConfig {

    private var mDestConfig: Map<String, Destination>? = null
    private var mBottomBar: BottomBar? = null

    fun getDestConfig(): Map<String, Destination> {

        if (mDestConfig.isNullOrEmpty()) {
            mDestConfig = Gson().fromJson<HashMap<String, Destination>>(
                parseFile("destination.json"),
                object : TypeToken<HashMap<String, Destination>>() {}.type
            )
        }

        return mDestConfig!!
    }


    /**
     * @description 获取底部导航配置信息
     * @author HaganWu
     * @date 1/9/22 8:28 PM
     */
    fun getBottomBar(): BottomBar {
        if (mBottomBar == null) {
            mBottomBar = Gson().fromJson<BottomBar>(
                parseFile("main_tabs_config.json"),
                BottomBar::class.java
            )
        }
        return mBottomBar!!
    }


    private fun parseFile(fileName: String): String {
        val assetManager = AppGlobals.getApplication().resources.assets
        assetManager.open(fileName).use {
            return it.bufferedReader().readText()
        }
    }
}