package com.luuren.kanmovie.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * doc
 * create by Luuren on 2019/12/27 10:59
 */

const val DATABASE_NAME = "roomname"

@Database(entities = [TestRoom::class], version = 1, exportSchema = false)
abstract class TestRoomDatabase : RoomDatabase() {

    abstract fun getTestRoomDao():TestRoomDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: TestRoomDatabase? = null

        fun getInstance(context: Context): TestRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TestRoomDatabase {
            return Room.databaseBuilder(context, TestRoomDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}