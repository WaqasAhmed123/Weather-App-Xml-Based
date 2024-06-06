package com.example.weather_xml.presentation.detailForecast.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_xml.R
import com.example.weather_xml.corePlatform.utilities.AppUtil
import com.example.weather_xml.corePlatform.utilities.AppUtil.extractTimeAndDay
import com.example.weather_xml.databinding.ActivityDetailForecastBinding
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import com.example.weather_xml.presentation.detailForecast.adapter.DailyForecastAdapter
import java.util.Locale

class DetailForecastActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityDetailForecastBinding
    val dayWiseTemp: MutableList<MutableList<Any>> = mutableListOf()
    private lateinit var dailyForecastAdapter: DailyForecastAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.activity_detail_forecast, null, false
        )
        setContentView(dataBinding.root)


        val weatherAndCityInfo =
            intent.getSerializableExtra("weatherAndCityInfo") as WeatherAndCityInfo

        dataBinding.tvLocation.text = weatherAndCityInfo.city!!.name
        dataBinding.tvSunriseTime.text =
            AppUtil.unixTimestampTo12HourFormat(weatherAndCityInfo.city.sunrise!!.toLong())
        dataBinding.tvSunsetTime.text =
            AppUtil.unixTimestampTo12HourFormat(weatherAndCityInfo.city.sunset!!.toLong())


        weatherAndCityInfo.weatherList?.forEachIndexed { index, weather ->
            if (index != 0 && index != 1) {
                // Get the icon URL
                val iconUrl =
                    "https://openweathermap.org/img/w/${weather.weather?.firstOrNull()?.icon}.png"

                // Convert temperature to Celsius
                val temperature = "${AppUtil.fahrenheitToCelsius(weather.main?.temp ?: 0.0)}°"
                val (time, day) = extractTimeAndDay(weather.dtTxt ?: "")

                // Create a list to hold the icon URL, temperature, and day
                val data = mutableListOf<Any>()
                data.add(iconUrl)
                data.add(temperature)
                data.add(day)
                data.add(time)

                // Add the data list to dayWiseTemp
                dayWiseTemp.add(data)
            }

        }
        dailyForecastAdapter = DailyForecastAdapter(dayWiseTemp = dayWiseTemp)
        dataBinding.rvDailyForecast.apply {
            layoutManager = LinearLayoutManager(
                this@DetailForecastActivity, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = dailyForecastAdapter
        }

         fun restartActivity() {
            val intent = Intent(this, DetailForecastActivity::class.java)
            startActivity(intent)
            finish()
        }

//        dataBinding.switchLanguage.setOnCheckedChangeListener { _, isChecked ->
//            val languageCode = if (isChecked) "en" else "ur"
//            setLocale(languageCode)
//            restartActivity()
//        }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
//    val config = resources.configuration
//    val lang = "ur" // your language code
//    val locale = Locale(lang)
//    Locale.setDefault(locale)
//    config.setLocale(locale)
//
//    createConfigurationContext(config)
//    resources.updateConfiguration(config, resources.displayMetrics)


}