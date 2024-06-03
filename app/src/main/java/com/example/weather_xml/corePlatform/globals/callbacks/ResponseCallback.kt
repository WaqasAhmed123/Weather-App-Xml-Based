package com.example.weather_xml.corePlatform.globals.callbacks

interface ResponseCallback <ResultType>{

    fun onSuccess(result: ResultType?)

}