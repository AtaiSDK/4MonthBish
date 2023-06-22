package com.example.a4monthbish.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4monthbish.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}