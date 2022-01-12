package com.hagan.libnetwork

import okhttp3.FormBody

/**
 * @author HaganWu
 * @description
 * @fileName PostRequest.kt
 * @date 1/12/22-9:28 PM
 */
class PostRequest<T>(private val url: String) : Request<T, PostRequest<T>>(url) {
    override fun generateRequest(builder: okhttp3.Request.Builder): okhttp3.Request {
        val bodyBuild = FormBody.Builder()
        for (map in params) {
            bodyBuild.add(map.key, map.value.toString())
        }
        return builder.url(url).post(bodyBuild.build()).build()
    }
}