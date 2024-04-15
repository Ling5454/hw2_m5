package com.example.hw2_m5.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2_m5.data.models.LoveModel
import com.example.hw2_m5.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SecondViewModel  @Inject constructor(private val repository: Repository):ViewModel() {
    fun getDBLove(): LiveData<List<LoveModel>> = repository.getDBLove()
    fun delete(fname:String) = repository.delete(fname)
}