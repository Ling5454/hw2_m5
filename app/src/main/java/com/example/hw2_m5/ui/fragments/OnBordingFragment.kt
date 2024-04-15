package com.example.hw2_m5.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw2_m5.R
import com.example.hw2_m5.data.local.Pref
import com.example.hw2_m5.databinding.FragmentOnBordingBinding
import com.example.hw2_m5.ui.fragments.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBordingFragment : Fragment() {
    @Inject
    lateinit var pref: Pref
    private lateinit var binding: FragmentOnBordingBinding

    private val adapter = OnBoardingAdapter(this::onClick)

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBordingBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.viewPager.adapter = adapter
        //binding.indicator.setViewPager(binding.viewPager)
    }
}