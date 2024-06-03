package com.example.weather_xml.presentation.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import com.example.weather_xml.BaseActivity
import com.example.weather_xml.presentation.detailForecast.view.DetailForecastActivity
import com.example.weather_xml.R
import com.example.weather_xml.data.repsitories.WeatherRepository
import com.example.weather_xml.databinding.ActivityHomeBinding
import com.example.weather_xml.domain.factory.HomeViewModelFactory
import com.example.weather_xml.domain.useCase.HomeUseCase
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
            val intent = Intent(this@HomeActivity, DetailForecastActivity::class.java)
            startActivity(intent)
        }

        homeViewModel.callWeatherAndCityInfoAPi()


    }


}