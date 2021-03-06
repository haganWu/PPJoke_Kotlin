package com.hagan.ppjoke

import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.gson.JsonObject
import com.hagan.libnetwork.GetRequest
import com.hagan.ppjoke.ui.view.AppBottomBar
import com.hagan.ppjoke.utils.NavGraphBuilder

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    lateinit var bottomBar: AppBottomBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar = findViewById(R.id.nav_view)

        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = fragment!!.findNavController()

        NavigationUI.setupWithNavController(bottomBar, navController!!)

        NavGraphBuilder.build(navController!!, this, fragment.id)

        //AppBottomBar的点击事件 和 navController 关联起来
        bottomBar.setOnNavigationItemSelectedListener(this::onNavItemSelected)

        GetRequest<JsonObject>("").execute()



    }

    private fun onNavItemSelected(menuItem: MenuItem): Boolean {
        navController?.navigate(menuItem.itemId)
        //返回 false 代表按钮没有被选中，也不会着色。如果为 true，就会着色，有一个上下浮动的效果
        return !TextUtils.isEmpty(menuItem.title)
    }
}