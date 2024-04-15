package com.example.hw2_m5.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw2_m5.data.models.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): LoveDao
}