package com.hagan.libnetwork

import java.lang.StringBuilder
import java.net.URLEncoder

/**
 * @author HaganWu
 * @description
 * @fileName UrlCreator.kt
 * @date 1/12/22-9:23 PM
 */
class UrlCreator {
    companion object {
        fun createUrlFromParams(url: String, params: Map<String, Any?>): String {
            val builder = StringBuilder()
            if (params.isEmpty()) return url
            builder.append(url)
            if (url.indexOf('?') > 0 || url.indexOf('&') > 0) {
                builder.append('&')
            } else {
                builder.append('?')
            }
            for (map in params) {
                //由于 value 是 Any 类型的，所以需要转为 UTF-8
                builder.append(map.key).append("=")
                    .append(URLEncoder.encode(map.value.toString(), "UTF-8")).append('&')
            }
            builder.deleteCharAt(builder.length - 1)
            return builder.toString()
        }
    }
}