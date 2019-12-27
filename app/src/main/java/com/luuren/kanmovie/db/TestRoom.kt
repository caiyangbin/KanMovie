package com.luuren.kanmovie.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * doc
 * create by Luuren on 2019/12/27 10:44
 */
@Entity(tableName = "testroom")
data class TestRoom(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String
)