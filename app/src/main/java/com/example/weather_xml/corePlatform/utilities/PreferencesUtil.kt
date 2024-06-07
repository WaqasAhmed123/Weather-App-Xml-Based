package com.example.weather_xml.corePlatform.utilities

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import androidx.annotation.NonNull
import com.example.weather_xml.corePlatform.globals.constant.AppConstants

object PreferencesUtil {

    private var sSharedPreferences: SharedPreferences? = null

    fun initialize(context: Context) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(
                AppConstants.PREFERENCE_STORAGE,
                Activity.MODE_PRIVATE
            )
        }
    }

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

    fun setIntegerPreference(key: String, value: Int): Boolean {
        if (sSharedPreferences != null) {
            val editor = sSharedPreferences!!.edit()
            editor.putInt(key, value)
            return editor.commit()
        }
        return false
    }

    fun getIntegerPreference(key: String, defaultValue: Int): Int {
        var value = defaultValue
        if (sSharedPreferences != null) {
            value = sSharedPreferences!!.getInt(key, defaultValue)
        }
        return value
    }

    fun getBooleanPreference(key: String, defaultValue: Boolean): Boolean {
        var value = defaultValue
        if (sSharedPreferences != null) {
            value = sSharedPreferences!!.getBoolean(key, defaultValue)
        }
        return value
    }

    fun setBooleanPreference(key: String, value: Boolean): Boolean {
        if (sSharedPreferences != null) {
            val editor = sSharedPreferences!!.edit()
            editor.putBoolean(key, value)
            return editor.commit()
        }
        return false
    }


}