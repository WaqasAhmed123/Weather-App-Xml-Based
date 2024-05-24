package com.example.weather_xml.Presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather_xml.Presentation.home.view.HomeActivity
import com.example.weather_xml.databinding.ActivitySplashBinding

class SplashActivity() : AppCompatActivity() {
    //    override val layoutId: Int
//        get() = R.layout.activity_splash
    lateinit var layoutBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(layoutBinding.root)



        layoutBinding.btnGetStart.setOnClickListener {
            val intent=Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)

        }
    }




}