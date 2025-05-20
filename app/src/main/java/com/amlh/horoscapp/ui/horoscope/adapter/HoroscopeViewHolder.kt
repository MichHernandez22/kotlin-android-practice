package com.amlh.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.amlh.horoscapp.databinding.ItemHoroscopeBinding
import com.amlh.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        val context = binding.tvTitleHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitleHoroscope.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, newLamda = {onItemSelected(horoscopeInfo)})
            //onItemSelected(horoscopeInfo)

        }
    }

    private fun startRotationAnimation(view: View, newLamda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLamda() }
            start()
        }
    }
}