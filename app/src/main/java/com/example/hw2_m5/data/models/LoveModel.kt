package com.example.hw2_m5.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("lovers")
data class LoveModel(
    @PrimaryKey(autoGenerate = true) val id: Int ?= null,
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String,
    ){
    override fun toString(): String {
        return "\n$fname  \n$sname \n$percentage \n$result"
    }
}