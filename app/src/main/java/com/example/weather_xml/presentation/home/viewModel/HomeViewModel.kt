package com.example.weather_xml.presentation.home.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_xml.corePlatform.globals.callbacks.ResponseCallback
import com.example.weather_xml.corePlatform.globals.common.base.BaseViewModel
import com.example.weather_xml.domain.useCase.HomeUseCase
import com.google.gson.JsonObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class HomeViewModel(private val homeUseCase: HomeUseCase) :BaseViewModel(),
    ResponseCallback<JsonObject> {

    private val _dataModel = MutableLiveData<JsonObject>()

    val dataModel: LiveData<JsonObject>
        get() = _dataModel


    @RequiresApi(Build.VERSION_CODES.O)
    val formattedDate =
        LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH))
    var currentTemp: MutableLiveData<String?> = MutableLiveData("")
    var tempMin: MutableLiveData<String?> = MutableLiveData("")
    var tempMax: MutableLiveData<String?> = MutableLiveData("")
    var feelsLike: MutableLiveData<String?> = MutableLiveData("")
    var description: MutableLiveData<String?> = MutableLiveData(null)
    var weatherDescriptionIconUrl: MutableLiveData<String?> = MutableLiveData(null)
    var cityName: MutableLiveData<String?> = MutableLiveData(null)
    var country: MutableLiveData<String?> = MutableLiveData(null)
    var sunriseTime: MutableLiveData<String?> = MutableLiveData(null)
    var sunsetTime: MutableLiveData<String?> = MutableLiveData(null)

    fun callWeatherAndCityInfoAPi() {
        _showProgress.value = true
        Log.d("fun called","true")
        homeUseCase.callWeatherAndCityInfoApi(lat= 24.932342, lon = 67.097506, callback = this)
    }

    override fun onSuccess(result: JsonObject?) {
        _dataModel.value = result!!
//        callWeatherAndCityInfoAPi()
        Log.d("dataModel is","${dataModel.value}")
        _showProgress.value = false
    }


}