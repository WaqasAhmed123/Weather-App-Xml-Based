package com.example.weather_xml.corePlatform.globals.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_xml.corePlatform.globals.callbacks.BaseError

open class BaseViewModel :ViewModel(), BaseError {
    protected val _showProgress = MutableLiveData<Boolean>()
    protected val _showError = MutableLiveData<Boolean>()
    private val _showNetworkError = MutableLiveData<Boolean>()


    val showError: LiveData<Boolean>
        get() = _showError
    val showNetworkError: LiveData<Boolean>
        get() = _showNetworkError
    val showProgress: LiveData<Boolean>
        get() = _showProgress

    override fun onNetworkError() {
        _showProgress.value = false
        _showNetworkError.value = true
    }

    override fun onFailure(message: String?) {
        _showProgress.value = false
        _showError.value = true
    }
}