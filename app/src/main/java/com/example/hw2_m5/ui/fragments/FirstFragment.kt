package com.example.hw2_m5.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hw2_m5.data.models.LoveModel
import com.example.hw2_m5.R
import com.example.hw2_m5.data.server.RetrofitService
import com.example.hw2_m5.databinding.FragmentFirstBinding
import com.example.hw2_m5.ui.viewmodels.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: FirstViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnHistory.setOnClickListener {
               findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }
            btnGetLove.setOnClickListener {
                val fname = binding.etFirstName.text.toString()
                val sname = binding.etSecondName.text.toString()
                viewModel.getLove(fname, sname).observe(viewLifecycleOwner, Observer {
                    tvResult.text = it.toString()
                    viewModel.insert(it)
                })
            }
        }
    }

 /*   private fun loadImage() {
        Glide.with(this)
            .load("https://image.winudf.com/v2/image/Y29tLm1tLmxvdmVjYWxjdWxhdG9yX3NjcmVlbl8zX2RyN2wwMXJ1/screen-3.jpg?fakeurl=1&type=.jpg")
            .into(binding.imgFf)
    }*/
}


/*
                RetrofitService.api.getLove(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {
                                val fname = response.body()?.fname
                                val sname = response.body()?.sname
                                val persantage = response.body()?.percentage
                                val result = response.body()?.result
                                val secondFragment = SecondFragment()
                                val bundle = Bundle()

                                bundle.putString("fname", fname.toString())
                                bundle.putString("sname", sname.toString())
                                bundle.putString("persantage", persantage.toString())
                                bundle.putString("result", result.toString())

                                secondFragment.arguments = bundle
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.container, secondFragment).commit()
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "onFailure:${t.message}")
                        }

                    })*/