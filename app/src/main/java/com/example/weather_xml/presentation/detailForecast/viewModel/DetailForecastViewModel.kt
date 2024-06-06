package com.example.weather_xml.presentation.detailForecast.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_xml.corePlatform.globals.callbacks.ResponseCallback
import com.example.weather_xml.corePlatform.globals.common.base.BaseViewModel
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import com.example.weather_xml.resources.localization.LocaleHelper
import java.util.Locale

class DetailForecastViewModel:BaseViewModel() {

    private val _isSwitchEnabled: MutableLiveData<Boolean> = MutableLiveData(LocaleHelper.getLanguage() != "ur")
    val isSwitchEnabled: LiveData<Boolean>
        get() = _isSwitchEnabled

    fun updateSwitchState(languageCode: String) {
        _isSwitchEnabled.value = languageCode != "ur"
    }



}