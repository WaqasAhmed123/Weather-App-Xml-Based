package com.example.weather_xml.application

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.weather_xml.corePlatform.globals.constant.AppConstants
import com.example.weather_xml.corePlatform.utilities.PreferencesUtil
import com.example.weather_xml.resources.localization.LocaleHelper

class GlobalStateApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializePreferences()
        checkForFirstTimeLaunch()
        setTheme()
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
    companion object {
        fun setTheme() {
            var theme = PreferencesUtil.getIntegerPreference(
                AppConstants.SYSTEM_THEME, 0
            )
//        if (theme==0) theme=1

            when (theme) { // 1-system theme | 2-light | 3-dark
                0 -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    )

                1 -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO
                    )

                2 -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES
                    )

                else -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO
                    )
            }
        }
    }

}