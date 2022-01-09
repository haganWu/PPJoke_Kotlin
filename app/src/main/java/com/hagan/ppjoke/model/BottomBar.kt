package com.hagan.ppjoke.model

/**
 * @description 底部导航Bean
 * @author HaganWu
 * @date 1/9/22 8:26 PM
 */
data class BottomBar(
    //被选中的颜色
    val activeColor: String,
    //默认的颜色
    val inActiveColor: String,
    //默认选中的 tabId
    val selectTab: Int,
    val tabs: List<Tab>
)

data class Tab(
    //是否可用
    val enable: Boolean,
    val index: Int,
    val pageUrl: String,
    val size: Int,
    val tintColor: String?,
    val title: String
)