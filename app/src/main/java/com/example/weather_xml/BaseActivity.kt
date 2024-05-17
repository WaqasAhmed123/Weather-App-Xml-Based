package com.example.weather_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}