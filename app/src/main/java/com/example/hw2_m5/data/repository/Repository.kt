package com.example.hw2_m5.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw2_m5.data.local.LoveDao
import com.example.hw2_m5.data.models.LoveModel
import com.example.hw2_m5.data.server.LoveApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi, private val dao: LoveDao) {


    fun getDBLove():LiveData<List<LoveModel>> = dao.getAll()

    fun delete(fname: String){
        dao.delete(fname)
    }

    fun insert(loveModel: LoveModel){
        dao.insert(loveModel)
    }

    fun getLove(fname:String,sname:String):MutableLiveData<LoveModel>{
        val love = MutableLiveData<LoveModel>()

        api.getLove(fname,sname).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    response.body()?.let {loveModel->
                        love.postValue(loveModel)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message}", )
            }

        })
        return love
    }
}