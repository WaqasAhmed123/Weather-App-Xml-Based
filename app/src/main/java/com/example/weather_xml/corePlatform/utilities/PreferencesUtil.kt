package com.example.weather_xml.corePlatform.utilities

import android.content.SharedPreferences
import android.text.TextUtils

object PreferencesUtil {

    private var sSharedPreferences: SharedPreferences? = null

    fun getStringPreference(key: String, defaultValue: String): String {
        var value: String = defaultValue
        if (sSharedPreferences != null) {
            value = sSharedPreferences!!.getString(key, defaultValue).toString()
        }
        return value
    }

    fun setStringPreference(key: String, value: String): Boolean {
        if (sSharedPreferences != null && !TextUtils.isEmpty(key)) {
            val editor = sSharedPreferences!!.edit()
            editor.putString(key, value)
            return editor.commit()
        }
        return false
    }


}