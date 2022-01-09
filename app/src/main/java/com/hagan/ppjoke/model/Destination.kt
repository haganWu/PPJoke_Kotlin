package com.hagan.ppjoke.model
/**
 * @author HaganWu
 * @description 注解使用对象
 * @fileName Destination.kt
 * @date 1/9/22-7:29 PM
 */
data class Destination(
    val asStarter: Boolean,
    val className: String,
    val id: Int,
    val isFragment: Boolean,
    val needLogin: Boolean,
    val pageUrl: String
)
