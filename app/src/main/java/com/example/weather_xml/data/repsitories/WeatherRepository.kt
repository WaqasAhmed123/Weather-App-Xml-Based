package com.example.weather_xml.data.repsitories

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.weather_xml.data.networkService.NetworkAPIUrls.BASE_URL
import com.example.weather_xml.data.networkService.endPoints.WeatherEndPoint
import com.example.weather_xml.data.networkService.retrofit.RetrofitRestClient
import com.example.weather_xml.domain.model.WeatherAndCityInfo
import com.example.weather_xml.presentation.home.viewModel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository <ResultType>{

    fun getWeatherAndCityInfoFromAPi(lat: Double,lon:Double) {
//        println("location while calling func $lat, $lon")
        val mApiInterface = RetrofitRestClient.getRetrofit()
            .create(WeatherEndPoint::class.java)
        val retrofitData =
//            mApiInterface.getWeatherAndCityInfo(lat = UserInfo.lat!!, lon = UserInfo.lon!!)
            mApiInterface.getWeatherAndCityInfo(lat = lat, lon = lon)
//            mApiInterface.getWeatherAndCityInfo()
        retrofitData.enqueue(object : Callback<WeatherAndCityInfo> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<WeatherAndCityInfo>, response: Response<WeatherAndCityInfo>
            ) {
                if (response.isSuccessful) {
                    println("rep is $response")
                    val completeWeatherData = response.body()
//                    HomeViewModel.updateWeatherDataInHomeViewModel(completeWeatherData!!)


                    println("response body is ${completeWeatherData}")
//                    isDataLoaded.value = true

                } else {
                    println("Response not successful: ${response.code()}")
                }

            }

            override fun onFailure(call: Call<WeatherAndCityInfo>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.message)
            }
        })


    }

    protected abstract fun onResponseSuccess(resultType: ResultType)

    protected abstract fun onResponseFailure(throwable: Throwable)
}