
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("kapt")

}
// Apply external script
apply(from = "$rootDir/config/version.gradle.kts")

android {
    namespace = "com.example.weather_xml"
    compileSdk = extra["newCompileSdk"] as Int

    defaultConfig {
        applicationId = "com.example.weather_xml"
        minSdk = extra["newMinSdk"] as Int
        targetSdk = extra["newTargetSdk"] as Int
        versionCode = extra["verCode"] as Int
        versionName = extra["verName"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = extra["compileVersion"] as JavaVersion
        targetCompatibility = extra["compileVersion"] as JavaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        //compose = true
        viewBinding=true
        dataBinding=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
val extraProperties = extra
dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //resp scrn size
    implementation ("com.intuit.ssp:ssp-android:${extraProperties["ssp"] as String}")
    implementation ("com.intuit.sdp:sdp-android:${extraProperties["sdp"] as String}")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:${extraProperties["retrofit_version"] as String}")
    implementation("com.squareup.retrofit2:converter-gson:${extraProperties["gson_version"] as String}")

    //glide to load remote image
    implementation ("com.github.bumptech.glide:glide:${extraProperties["glide"] as String}")

    //shimmer
    implementation ("com.facebook.shimmer:shimmer:${extraProperties["shimmer"] as String}")

    //kapt
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")

//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

}