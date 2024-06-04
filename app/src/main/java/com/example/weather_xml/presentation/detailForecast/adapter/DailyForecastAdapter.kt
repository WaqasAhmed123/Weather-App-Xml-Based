package com.example.weather_xml.presentation.detailForecast.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weather_xml.databinding.LayoutDailyForecastBinding

class DailyForecastAdapter(private val dayWiseTemp: MutableList<MutableList<Any>>) :
    RecyclerView.Adapter<DailyForecastAdapter.DailyForecastViewHolder>() {

//    val dayWiseTemp = this.da


    inner class DailyForecastViewHolder(var binding: LayoutDailyForecastBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder {
        return  DailyForecastViewHolder(LayoutDailyForecastBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun getItemCount(): Int {
        Log.d("day&TempListAdapter","${dayWiseTemp}")
        return dayWiseTemp.size
    }

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(dayWiseTemp[position][0]).into(holder.binding.ivWeatherIcon)
        holder.binding.tvTemperature.text = dayWiseTemp[position][1].toString()
        holder.binding.tvDay.text = dayWiseTemp[position][2].toString()
        holder.binding.tvTime.text = dayWiseTemp[position][3].toString()
    }
}