package com.example.weather_xml.presentation.detailForecast.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_xml.corePlatform.globals.callbacks.ResponseCallback
import com.example.weather_xml.corePlatform.globals.common.base.BaseViewModel
import com.example.weather_xml.corePlatform.globals.constant.AppConstants
import com.example.weather_xml.corePlatform.utilities.PreferencesUtil
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import com.example.weather_xml.resources.localization.LocaleHelper
import java.util.Locale

class DetailForecastViewModel : BaseViewModel() {

    private val _isLangSwitchEnabled: MutableLiveData<Boolean> =
        MutableLiveData(LocaleHelper.getLanguage() != "ur")
    private val _isThemeSwitchEnabled: MutableLiveData<Boolean> =
        MutableLiveData(PreferencesUtil.getIntegerPreference(AppConstants.SYSTEM_THEME, 1) == 2)
    val isLangSwitchEnabled: LiveData<Boolean>
        get() = _isLangSwitchEnabled
    val isThemeSwitchEnabled: LiveData<Boolean>
        get() = _isThemeSwitchEnabled

    fun updateSwitchState(languageCode: String) {
        _isLangSwitchEnabled.value = languageCode != "ur"
    }


}