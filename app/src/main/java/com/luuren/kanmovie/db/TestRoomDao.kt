package com.luuren.kanmovie.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * doc
 * create by Luuren on 2019/12/27 10:51
 */
@Dao
interface TestRoomDao {
    @Insert
    suspend fun insert(testRoom: TestRoom): Long

    @Query("SELECT * FROM testroom ORDER BY name")
    suspend fun queryAll(): List<TestRoom>
}