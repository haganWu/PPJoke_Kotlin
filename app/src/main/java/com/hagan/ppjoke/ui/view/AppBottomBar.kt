package com.hagan.ppjoke.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.hagan.ppjoke.R
import com.hagan.ppjoke.utils.AppConfig
import com.hagan.ppjoke.utils.DisplayUtil

class AppBottomBar : BottomNavigationView {

    companion object {
        val icons = intArrayOf(
            R.mipmap.icon_tab_home, R.mipmap.icon_tab_sofa,
            R.mipmap.icon_tab_publish, R.mipmap.icon_tab_find, R.mipmap.icon_tab_mine
        )
    }


    constructor(context: Context) : super(context) {
        initBottomBar()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initBottomBar()
    }

    @SuppressLint("RestrictedApi")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initBottomBar()
    }

    @SuppressLint("RestrictedApi")
    private fun initBottomBar() {
        val bottomBar = AppConfig.getBottomBar()
        val tabs = bottomBar.tabs

        //二位数组，用来定义底部按钮在选中或者未被选中时两种状态的颜色
        val states = Array(2) { intArrayOf() }
        states[0] = intArrayOf(android.R.attr.state_selected)
        states[1] = intArrayOf()
        val colors = intArrayOf(
            //被选中的颜色
            Color.parseColor(bottomBar.activeColor),//"#ff0000"
            //按钮默认的颜色
            Color.parseColor(bottomBar.inActiveColor)
        )
        val colorStateList = ColorStateList(states, colors)
        //设置颜色
        itemTextColor = colorStateList
        itemIconTintList = colorStateList

        //所有的按钮在任何时候都需要显示文本
        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        //设置默认选中的按钮
        selectedItemId = bottomBar.selectTab
        //将按钮添加到 BottomBar 上面
        for (tab in tabs) {
            if (!tab.enable) {
                return
            }
            val itemId = getId(tab.pageUrl)
            if (itemId < 0) {
                return
            }
            val item = menu.add(0, itemId, tab.index, tab.title)
            item?.setIcon(icons[tab.index])
        }
        //按钮 Icon 设置大小
        tabs.forEach {
            val menuView = getChildAt(0) as BottomNavigationMenuView
            val itemView = menuView.getChildAt(it.index) as BottomNavigationItemView
            itemView.setIconSize(DisplayUtil.dp2px(context, it.size))

            //给中间的按钮设置着色
            if (TextUtils.isEmpty(it.title)) {
                itemView.setIconTintList(ColorStateList.valueOf(Color.parseColor(it.tintColor)))
                //点击的时候不会有上下浮动的效果
                itemView.setShifting(false)
            }
        }
    }


    private fun getId(pageUrl: String): Int {
        val destination = AppConfig.getDestConfig()[pageUrl] ?: return -1
        return destination.id
    }
}