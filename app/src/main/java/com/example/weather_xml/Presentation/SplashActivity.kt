package com.example.weather_xml.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.weather_xml.BaseActivity
import com.example.weather_xml.R
import com.example.weather_xml.databinding.ActivitySplashBinding

class SplashActivity() : AppCompatActivity() {
//    override val layoutId: Int
//        get() = R.layout.activity_splash
    private lateinit var layoutBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(layoutBinding.root)
    }
}