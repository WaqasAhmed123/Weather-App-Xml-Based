package com.example.weather_xml.data.networkService.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//import retrofit2.Retrofit

object RetrofitRestClient {

    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
//                .baseUrl("https://apim-prod.visitabudhabi.ae/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!

    }
}