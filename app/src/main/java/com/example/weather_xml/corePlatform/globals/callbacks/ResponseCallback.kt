package com.example.weather_xml.corePlatform.globals.callbacks

interface ResponseCallback <ResultType> : BaseError{

    fun onSuccess(result: ResultType?)

}