package com.example.weather_xml.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherAndCityInfo(
    @SerializedName("city") val city: City?,
    @SerializedName("list") val weatherList: List<WeatherData>?
) : Serializable

data class City(
    @SerializedName("name") val name: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("sunrise") val sunrise: Int?,
    @SerializedName("sunset") val sunset: Int?
): Serializable

data class WeatherData(
    @SerializedName("main") val main: Main?,
    @SerializedName("weather") val weather: List<Weather>?,
    @SerializedName("dt_txt") val dtTxt: String?
): Serializable

data class Main(
    @SerializedName("temp") val temp: Double?,
    @SerializedName("feels_like") val feelsLike: Double?,
    @SerializedName("temp_min") val tempMin: Double?,
    @SerializedName("temp_max") val tempMax: Double?,
    @SerializedName("pressure") val pressure: Int?,
    @SerializedName("sea_level") val seaLevel: Int?,
    @SerializedName("grnd_level") val groundLevel: Int?,
    @SerializedName("humidity") val humidity: Int?,
    @SerializedName("temp_kf") val tempKf: Double?
): Serializable

data class Weather(
    @SerializedName("id") val id: Int?,
    @SerializedName("main") val main: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("icon") val icon: String?
): Serializable