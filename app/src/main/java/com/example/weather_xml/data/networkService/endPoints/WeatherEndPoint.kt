package com.example.weather_xml.data.networkService.endPoints

import com.example.weather_xml.data.networkService.NetworkAPIUrls
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherEndPoint {

    @GET(NetworkAPIUrls.WEATHER_API)
    fun getWeatherAndCityInfo(
        @Query("lat") lat: Double, @Query("lon") lon: Double
    ): Call<WeatherAndCityInfo>

}