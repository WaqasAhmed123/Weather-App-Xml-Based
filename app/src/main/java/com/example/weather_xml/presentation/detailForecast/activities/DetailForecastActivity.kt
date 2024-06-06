package com.example.weather_xml.presentation.detailForecast.activities

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_xml.R
import com.example.weather_xml.corePlatform.globals.common.base.BaseActivity
import com.example.weather_xml.corePlatform.utilities.AppUtil
import com.example.weather_xml.corePlatform.utilities.AppUtil.extractTimeAndDay
import com.example.weather_xml.corePlatform.utilities.PreferencesUtil
import com.example.weather_xml.databinding.ActivityDetailForecastBinding
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import com.example.weather_xml.presentation.detailForecast.adapter.DailyForecastAdapter
import com.example.weather_xml.presentation.detailForecast.viewModel.DetailForecastViewModel
import com.example.weather_xml.presentation.splash.SplashActivity
import com.example.weather_xml.resources.localization.LocaleHelper
import com.example.weather_xml.resources.localization.LocaleHelper.setLocale
import java.util.Locale

class DetailForecastActivity : BaseActivity() {

    private  var dataBinding: ActivityDetailForecastBinding?= null
    val dayWiseTemp: MutableList<MutableList<Any>> = mutableListOf()
    private lateinit var dailyForecastAdapter: DailyForecastAdapter

    // Initialize the ViewModel
    private val viewModel: DetailForecastViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.activity_detail_forecast, null, false
        )
        setContentView(dataBinding!!.root)


        val weatherAndCityInfo =
            intent.getSerializableExtra("weatherAndCityInfo") as WeatherAndCityInfo

        dataBinding!!.tvLocation.text = weatherAndCityInfo.city!!.name
        dataBinding!!.tvSunriseTime.text =
            AppUtil.unixTimestampTo12HourFormat(weatherAndCityInfo.city.sunrise!!.toLong())
        dataBinding!!.tvSunsetTime.text =
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
        dataBinding!!.rvDailyForecast.apply {
            Log.d("recyclerViewVisible","${dataBinding!!.rvDailyForecast.isVisible}")
            layoutManager = LinearLayoutManager(
                this@DetailForecastActivity, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = dailyForecastAdapter
        }

        // Observe the switch state from the ViewModel
        viewModel.isSwitchEnabled.observe(this, Observer { isSwitchEnabled ->
            isSwitchEnabled?.let {
                dataBinding!!.switchLanguage.isChecked = it
            }
        })



        dataBinding!!.switchLanguage.setOnClickListener {
            Log.d("lang changeSwitch", "${LocaleHelper.getLanguage()}")
            val languageCode = if (dataBinding!!.switchLanguage.isChecked) "en" else "ur"
            LocaleHelper.setLocale(
                this, languageCode
            )
//            viewModel.updateSwitchState(languageCode)
            restartActivity()
        }
    }


    fun restartActivity() {
        val intent = Intent(this, SplashActivity::class.java)
        intent.flags = FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        dataBinding = null
    }

}