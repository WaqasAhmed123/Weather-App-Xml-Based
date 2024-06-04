extra.apply {
    set("newCompileSdk", 34)
    set("newMinSdk", 24)
    set("newTargetSdk", 34)

    // Version code
    set("verCode", 1)

    // Semantic Versioning
    val MAJOR = 1
    val MINOR = 0
    val PATCH = 0

    set("verName", "$MAJOR.$MINOR.$PATCH")

    // Java version
    set("compileVersion", JavaVersion.VERSION_1_8)

    // 3rd Party libraries
    set("sdp", "1.0.6")
    set("ssp", "1.0.6")
    set("kapt", "2.0.0")
    set("retrofit_version", "2.11.0")
    set("gson_version", "2.11.0")
    set("glide", "4.12.0")
}
