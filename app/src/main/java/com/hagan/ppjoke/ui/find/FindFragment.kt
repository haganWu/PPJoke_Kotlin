package com.hagan.ppjoke.ui.find

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hagan.libcommon.utils.L
import com.hagan.libnavannotation.FragmentDestination
import com.hagan.ppjoke.R

@FragmentDestination(pageUrl = "main/tabs/find")
class FindFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        L.e("FindFragment ->onCreateView()")
        return inflater.inflate(R.layout.fragment_find, container, false)
    }
}