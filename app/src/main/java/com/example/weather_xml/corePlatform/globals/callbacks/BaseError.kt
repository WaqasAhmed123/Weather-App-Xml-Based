package com.example.weather_xml.corePlatform.globals.callbacks

interface BaseError {

    fun onNetworkError()

    fun onFailure(message: String?)
}