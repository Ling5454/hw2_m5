package com.example.hw2_m5.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw2_m5.R
import com.example.hw2_m5.data.models.OnBoardingModel
import com.example.hw2_m5.databinding.ItemOnBoardingBinding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<OnBoardingModel>(
        OnBoardingModel(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.love1
        ),
        OnBoardingModel(
            "Cherishing love",
            "It is no longer possible for you to cherish love",
            R.raw.love2
        ),
        OnBoardingModel(
            "Have a breakup?",
            "We have the correction for you don't worry \n mayby someone is waiting for you!",
        R.raw.love3
            ),
        OnBoardingModel(
            "It's funs and many more!",
            "",
            R.raw.love4
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])

    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoardingModel) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            btnGetStarted.isVisible = adapterPosition == list.lastIndex
            //ivBoard.loadImage(onBoarding.image.toString())
            // Glide.with(binding.ivBoard).load(onBoarding.image).into(ivBoard)
            onBoarding.lottieAnim?.let {
                ivBoard.setAnimation(onBoarding.lottieAnim)
                ivBoard.playAnimation()
            }

            btnGetStarted.setOnClickListener {
                onClick()
            }
        }
    }
}