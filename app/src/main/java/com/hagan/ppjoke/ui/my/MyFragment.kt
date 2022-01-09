package com.hagan.ppjoke.ui.my

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hagan.libcommon.utils.L
import com.hagan.libnavannotation.FragmentDestination
import com.hagan.ppjoke.R

@FragmentDestination(pageUrl = "main/tabs/my")
class MyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        L.e("MyFragment ->onCreateView()")
        return inflater.inflate(R.layout.fragment_my, container, false)
    }


}