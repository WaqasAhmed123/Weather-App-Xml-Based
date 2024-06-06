package com.example.weather_xml.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather_xml.corePlatform.globals.common.base.BaseActivity
import com.example.weather_xml.presentation.home.activities.HomeActivity
import com.example.weather_xml.databinding.ActivitySplashBinding

class SplashActivity() : BaseActivity() {
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