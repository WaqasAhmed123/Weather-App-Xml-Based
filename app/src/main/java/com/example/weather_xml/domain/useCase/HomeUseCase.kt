package com.example.weather_xml.domain.useCase

import com.example.weather_xml.corePlatform.globals.callbacks.ResponseCallback
import com.example.weather_xml.data.repositories.WeatherRepository
import com.google.gson.JsonObject

class HomeUseCase(
    private val weatherRepository: WeatherRepository

) {

    fun callWeatherAndCityInfoApi(
        lat: Double, lon: Double, callback: ResponseCallback<JsonObject>
    ) {
        return weatherRepository.getWeatherAndCityInfoFromApi(lat = lat, lon = lon)
    }
}