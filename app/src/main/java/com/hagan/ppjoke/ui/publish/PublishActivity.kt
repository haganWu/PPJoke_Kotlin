package com.hagan.ppjoke.ui.publish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hagan.libnavannotation.ActivityDestination
import com.hagan.ppjoke.R

@ActivityDestination(pageUrl = "main/tabs/publish")
class PublishActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)

        supportActionBar?.title = "发布"
    }
}