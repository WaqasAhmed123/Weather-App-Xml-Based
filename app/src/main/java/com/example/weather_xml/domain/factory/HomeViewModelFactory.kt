package com.example.weather_xml.domain.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather_xml.domain.useCase.HomeUseCase
import com.example.weather_xml.presentation.home.viewModel.HomeViewModel

class HomeViewModelFactory(private val homeUseCase : HomeUseCase): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (HomeViewModel(homeUseCase) as T)


}