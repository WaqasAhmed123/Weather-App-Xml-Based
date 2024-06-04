package com.example.weather_xml.domain.useCase

import com.example.weather_xml.corePlatform.globals.callbacks.ResponseCallback
import com.example.weather_xml.data.repsitories.WeatherRepository
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import com.example.weather_xml.presentation.home.viewModel.HomeViewModel
import com.google.gson.JsonObject

class HomeUseCase(
    private val weatherRepository: WeatherRepository

) {

    fun callWeatherAndCityInfoApi(
        lat: Double, lon: Double, callback: ResponseCallback<WeatherAndCityInfo>
    ) {
        return weatherRepository.getWeatherAndCityInfoFromApi(lat = lat, lon = lon , callback = callback)
    }
}