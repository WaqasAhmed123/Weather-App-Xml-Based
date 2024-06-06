package com.example.weather_xml.application

import android.app.Application
import android.util.Log
import com.example.weather_xml.corePlatform.globals.constant.AppConstants
import com.example.weather_xml.corePlatform.utilities.PreferencesUtil
import com.example.weather_xml.resources.localization.LocaleHelper

class GlobalStateApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializePreferences()
        checkForFirstTimeLaunch()
    }

    private fun initializePreferences() {
        PreferencesUtil.initialize(this)
        Log.d("preference","init")

    }

    private fun checkForFirstTimeLaunch() {
        if (!PreferencesUtil.getBooleanPreference(AppConstants.IS_DEFAULT_DATA_LOADED, false)) {
            LocaleHelper.initAppLang(this)
            PreferencesUtil.setBooleanPreference(AppConstants.IS_DEFAULT_DATA_LOADED, true)
            Log.d("preference","firstTimeLaunch")

        }
    }

}