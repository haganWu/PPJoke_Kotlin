package com.hagan.libnetwork

/**
 * @author HaganWu
 * @description
 * @fileName JsonCallback.kt
 * @date 1/12/22-9:28 PM
 */
abstract class JsonCallback<T> {

    open fun onSuccess(response: ApiResponse<T>) {

    }

    open fun onError(response: ApiResponse<T>) {

    }

    open fun onCacheSuccess(response: ApiResponse<T>) {

    }
}