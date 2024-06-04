package com.example.weather_xml.corePlatform.utilities

import android.os.Build
import androidx.annotation.RequiresApi
import java.math.RoundingMode
import java.text.DecimalFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.roundToInt

object AppUtil {

    fun fahrenheitToCelsius(fahrenheit: Double): Int {
        return (fahrenheit - 273.15).roundToInt()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun unixTimestampTo12HourFormat(unixTimestamp: Long): String {
        val dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochSecond(unixTimestamp), ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
        return dateTime.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun extractTimeAndDay(dtTxt: String): Pair<String, String> {
        // Parse the string to LocalDateTime
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        val dateTime = LocalDateTime.parse(dtTxt, formatter)

        // Extract time in 12-hour format
        val timeFormatter = DateTimeFormatter.ofPattern("hh a", Locale.ENGLISH)
        val time = dateTime.format(timeFormatter)

        // Extract day
        val dayFormatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
        val day = dateTime.format(dayFormatter)

        return Pair(time, day)
    }


}