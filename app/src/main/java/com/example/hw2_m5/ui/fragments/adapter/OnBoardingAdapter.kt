package com.example.hw2_m5.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw2_m5.data.models.OnBoardingModel
import com.example.hw2_m5.databinding.ItemOnBoardingBinding

class OnBoardingAdapter  (private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){
    private val list = arrayListOf<OnBoardingModel>(
        OnBoardingModel("Have a good time", "You should take the time to help those who need you", "https://thewrightinitiative.com/800/600/http/i.kym-cdn.com/photos/images/original/002/111/363/7d3.jpg"),
        OnBoardingModel("Cherishing love", "It is no longer possible for you to cherish love", "https://i.pinimg.com/736x/bd/90/92/bd9092d31e092f9e9faee42fa9453044.jpg"),
        OnBoardingModel("Have a breakup?", "We have the correction for you don't worry \n mayby someone is waiting for you!", "https://news.masscommunicationtalk.com/wp-content/uploads/2020/11/breakup.jpg"),
        OnBoardingModel("It's funs and many more!", "", "https://image.winudf.com/v2/image/Y29tLm5pa2hpbDJhZ3Jhd2FsLmxvdmVfY2FsY3VsYXRvcl9zY3JlZW5fNV8xNTI2NDgzNTEwXzAwNA/screen-5.jpg?fakeurl=1&type=.jpg")
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

    override fun getItemCount(): Int= list.size

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
            Glide.with(binding.ivBoard).load(onBoarding.image).into(ivBoard)

            btnGetStarted.setOnClickListener {
                onClick()
            }
        }
    }
}