package com.hagan.libnetwork.cache


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @author HaganWu
 * @description
 * @fileName Cache.kt
 * @date 1/12/22-9:25 PM
 */
@Entity(tableName = "cache")
class Cache : Serializable {

    //主键约束，保证 key 的唯一性
    @NonNull
    @PrimaryKey
    var key: String? = ""

    @ColumnInfo
    var data: ByteArray? = null


}