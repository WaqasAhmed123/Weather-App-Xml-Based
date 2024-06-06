package com.example.weather_xml.corePlatform.globals.common.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import com.example.weather_xml.resources.localization.LocaleHelper

abstract class BaseActivity : AppCompatActivity() {
//    protected abstract val layoutId: Int

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(layoutId)
//    }

    override fun attachBaseContext(@NonNull context: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(context))
    }
}