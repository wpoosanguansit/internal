plugins {
    id("plugin.android-common")
}

dependencies {
    COMMON_THEME
    COMMON_COMPOSABLE
    CORE
}

android {
    namespace = "com.playground.internal.feature.udine4me"
    compileSdkVersion = AppConfig.compileSdkVersion
}