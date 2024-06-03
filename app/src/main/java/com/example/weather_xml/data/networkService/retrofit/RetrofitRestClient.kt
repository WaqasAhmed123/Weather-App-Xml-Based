package com.example.weather_xml.data.networkService.retrofit

import com.example.weather_xml.data.networkService.NetworkAPIUrls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRestClient {

    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(NetworkAPIUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!

    }
}