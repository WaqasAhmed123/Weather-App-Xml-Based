package com.example.weather_xml.presentation.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.weather_xml.presentation.detailForecast.view.DetailForecastActivity
import com.example.weather_xml.R
import com.example.weather_xml.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.activity_home, null, false
        )
        setContentView(dataBinding.root)

        dataBinding.tvSeeMore.setOnClickListener {
            val intent = Intent(this@HomeActivity, DetailForecastActivity::class.java)
            startActivity(intent)
        }
    }
}