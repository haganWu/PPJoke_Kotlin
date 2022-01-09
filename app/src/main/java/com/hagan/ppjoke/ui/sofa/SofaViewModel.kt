package com.hagan.ppjoke.ui.sofa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SofaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Sofa"
    }
    val text: LiveData<String> = _text
}