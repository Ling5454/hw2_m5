package com.example.hw2_m5.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.hw2_m5.R
import com.example.hw2_m5.databinding.FragmentSecondBinding
import com.example.hw2_m5.ui.viewmodels.SecondViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDelete.setOnClickListener {
            viewModel.delete(binding.etFirstName.text.toString())
        }
        viewModel.getDBLove().observe(viewLifecycleOwner, Observer { list ->
            list.forEach {
                binding.tvResult.text = list.joinToString(separator = "", prefix = "", postfix = "")
            }
        })
    }
}

/*   Glide.with(this)
            .load("https://is5-ssl.mzstatic.com/image/thumb/Purple128/v4/b8/88/27/b88827d7-936f-ffe3-9aae-291a16f46121/AppIcon-1x_U007emarketing-85-220-3.png/1080x800bb.jpg")
            .into(binding.imgSf)

        var result = arguments?.getString("result")
        var fname = arguments?.getString("fname")
        var sname = arguments?.getString("sname")
        var persantage = arguments?.getString("persantage")

        with(binding) {
            tvFirstName.text = fname.toString()
            tvSecondName.text = sname.toString()
            tvPersantage.text = persantage.toString()
            tvResult.text = result.toString()

            btnTryAgain.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
            }
        }*/