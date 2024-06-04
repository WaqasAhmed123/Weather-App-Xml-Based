package com.example.weather_xml.presentation.home.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.weather_xml.R
import com.example.weather_xml.data.repsitories.WeatherRepository
import com.example.weather_xml.databinding.ActivityHomeBinding
import com.example.weather_xml.domain.factory.HomeViewModelFactory
import com.example.weather_xml.domain.useCase.HomeUseCase
import com.example.weather_xml.presentation.detailForecast.activities.DetailForecastActivity
import com.example.weather_xml.presentation.home.viewModel.HomeViewModel


class HomeActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityHomeBinding

    private val homeViewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory(
            HomeUseCase(WeatherRepository()),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.activity_home, null, false
        )
        setContentView(dataBinding.root)

        dataBinding.tvSeeMore.setOnClickListener {
//            val temptInt
            val intent = Intent(this@HomeActivity, DetailForecastActivity::class.java)
            intent.putExtra("weatherAndCityInfo", homeViewModel.dataModel.value)
//            intent.put
            startActivity(intent)
        }

        homeViewModel.callWeatherAndCityInfoAPi()

        dataBinding.viewModel = homeViewModel
        dataBinding.lifecycleOwner = this

        homeViewModel.weatherDescriptionIconUrl.observe(this, Observer {
//            dataBinding.ivWeather =
            Glide.with(applicationContext).load(it).into(dataBinding.ivWeather)

        })

//        homeViewModel.
//        Glide.with(holder.itemView.context).load(categoriesList[position].strCategoryThumb).into(holder.binding.imgCategory)
//        holder.binding.tvCategoryName.text=categoriesList[position].strCategory
//        holder.itemView.setOnClickListener{
//            onItemClick.invoke(categoriesList[position])
//
//        }


    }


}