package com.example.hw2_m5.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hw2_m5.data.models.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT*FROM lovers ORDER BY fname ASC")
    fun getAll(): LiveData<List<LoveModel>>

    @Query("DELETE FROM lovers WHERE fname = :fName")
    fun delete(fName: String)
}