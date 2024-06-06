package com.example.weather_xml.resources.localization

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.util.Log
import androidx.annotation.NonNull
import com.example.weather_xml.corePlatform.utilities.PreferencesUtil
import java.util.Locale

object LocaleHelper {

    private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"
    const val LANGUAGE_URDU_LOCALE_CODE = "ur"
    const val LANGUAGE_ENGLISH_LOCALE_CODE = "en"


    fun initAppLang(context: Context) {
        PreferencesUtil.initialize(context)
        var language = PreferencesUtil.getStringPreference(
            SELECTED_LANGUAGE, ""
        )
        if (language.isNotEmpty()) {
            return
        } else {
            language = defaultLanguageCode()
//            if (SupportedLanguages.isSupported(language)) {
//                setLocaleForFreshInstall(context, language)
//            } else {
            setLocale(
                context, defaultLanguageCode()
            )
//            }
        }

    }

    fun getLanguage(): String {
        return getPersistedData(defaultLanguageCode())
    }

    fun setLocale(context: Context, language: String): Context {
        persist(language)
//        var languageList = language.split("-")
        var localeLanguage = language
//        if (languageList != null && languageList.isNotEmpty()) {
//            localeLanguage = languageList[0]
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(context, localeLanguage)
        }
        return updateResourcesLegacy(context, language)
    }

    private fun updateResourcesLegacy(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources = context.resources

        val configuration = resources.configuration
        configuration.locale = locale

        resources.updateConfiguration(configuration, resources.displayMetrics)

        return context
    }


    private fun defaultLanguageCode(): String {

        var deviceLanguageCode: String = Locale.getDefault().language
        if (deviceLanguageCode.isNotEmpty()) {
            if (deviceLanguageCode.contains(
                    LANGUAGE_URDU_LOCALE_CODE, true
                )
            //                || deviceLanguageCode.contains(
//                    LANGUAGE_HEBREW_LOCALE_CODE2,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_ITALIAN_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_DEUTSCH_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_ITALIAN_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_FRENCH_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_RUSSIAN_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_ARABIC_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_CHINESE_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_SOUTH_KOREAN_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_POLISH_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(
//                    LANGUAGE_SPANISH_LOCALE_CODE,
//                    true
//                ) || deviceLanguageCode.contains(LANGUAGE_DUTCH_LOCALE_CODE, true)
            ) {
                return deviceLanguageCode
            } else {
                return LANGUAGE_ENGLISH_LOCALE_CODE
            }
        } else {
            return LANGUAGE_ENGLISH_LOCALE_CODE
        }
    }

    private fun persist(language: String) {
        PreferencesUtil.setStringPreference(
            SELECTED_LANGUAGE, language
        )
    }

    private fun getPersistedData(defaultLanguage: String): String {
        return PreferencesUtil.getStringPreference(
            SELECTED_LANGUAGE, defaultLanguage
        )
    }

    private fun updateResources(context: Context, language: String): Context {
        var context = context
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res = context.resources
        try {
            val config = Configuration(res.configuration)
            config.setLayoutDirection(locale)
            config.setLocale(locale)
            context = context.createConfigurationContext(config)
        } catch (ex: Exception) {
            Log.d("lang change", "$ex")

            //VADLog.error(ex)
        }
        return context
    }

    fun onAttach(@NonNull context: Context): Context {
        val lang = getPersistedData(defaultLanguageCode())
        Log.d("lang changeOnAtt", "$lang")

        return setLocale(context, lang)
    }
}