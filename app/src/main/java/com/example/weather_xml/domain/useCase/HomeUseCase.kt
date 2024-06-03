package com.example.weather_xml.domain.useCase

import com.example.weather_xml.data.repsitories.WeatherRepository
import com.google.gson.JsonObject
import com.example.weather_xml.corePlatform.globals.callbacks.ResponseCallback

class HomeUseCase(
    private val weatherRepository: WeatherRepository

) {

    fun callWeatherAndCityInfoApi(
        lat: Double, lon: Double, callback: ResponseCallback<JsonObject>
    ) {
        return weatherRepository.getWeatherAndCityInfoFromAPi(lat = lat, lon = lon)
    }
}