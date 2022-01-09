package com.hagan.ppjoke.utils

import android.content.ComponentName
import androidx.fragment.app.FragmentActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import com.hagan.libcommon.AppGlobals
import com.hagan.ppjoke.ui.view.FixFragmentNavigator

class NavGraphBuilder {
    companion object {
        fun build(navController: NavController, activity: FragmentActivity, containerId: Int) {

            val provider = navController.navigatorProvider

            //节点集合
            val navGraph = NavGraph(NavGraphNavigator(provider))

            //获取已经注册的导航
//            val fragmentNavigator = provider.getNavigator(FragmentNavigator::class.java)
            //使用自定义的导航器
            val fragmentNavigator =
                FixFragmentNavigator(activity, activity.supportFragmentManager, containerId)
            //添加自定义的导航器
            provider.addNavigator(fragmentNavigator)

            val activityNavigator = provider.getNavigator(ActivityNavigator::class.java)
            val destConfig = AppConfig.getDestConfig()
            destConfig.forEach {
                if (it.value.isFragment) {
                    val destination = fragmentNavigator.createDestination()
                    destination.className = it.value.className
                    destination.id = it.value.id
                    destination.addDeepLink(it.value.pageUrl)
                    //添加节点
                    navGraph.addDestination(destination)
                } else {
                    val destination = activityNavigator.createDestination()
                    destination.id = it.value.id
                    destination.addDeepLink(it.value.pageUrl)
                    destination.setComponentName(
                        ComponentName(
                            AppGlobals.getApplication().packageName,
                            it.value.className
                        )
                    )
                    navGraph.addDestination(destination)
                }

                //如果是默认的启动页
                if (it.value.asStarter) {
                    navGraph.startDestination = it.value.id
                }
            }
            //设置新的节点集合
            navController.graph = navGraph
        }

    }

}