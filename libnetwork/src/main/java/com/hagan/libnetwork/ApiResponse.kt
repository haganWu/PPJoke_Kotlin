package com.hagan.libnetwork

/**
 * @author HaganWu
 * @description
 * @fileName ApiResponse.kt
 * @date 1/12/22-9:27 PM
 */
class ApiResponse<T>() {
    var success = false
    var status = 0
    var message: String? = null
    var body: T? = null
}