package com.example.hw2_m5.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2_m5.data.models.LoveModel
import com.example.hw2_m5.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: Repository) :ViewModel() {
    fun getLove(fname:String,sname:String):LiveData<LoveModel> = repository.getLove(fname,sname)
    fun insert(loveModel: LoveModel) = repository.insert(loveModel)
}