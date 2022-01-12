package com.hagan.libnetwork

import android.util.Log

class GetRequest<T>(private val url: String) : Request<T, GetRequest<T>>(url) {
    override fun generateRequest(builder: okhttp3.Request.Builder): okhttp3.Request {
        Log.e("0000000000000000000",UrlCreator.createUrlFromParams(url, params))
        return builder.get().url(UrlCreator.createUrlFromParams(url, params)).build()
    }
}