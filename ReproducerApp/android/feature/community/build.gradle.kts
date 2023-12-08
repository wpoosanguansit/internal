plugins {
    id("plugin.android-common")
}


dependencies {
    COMMON_COMPOSABLE
    COMMON_THEME
    CORE
}

android {
    namespace = "com.playground.internal.feature.community"
    compileSdkVersion = AppConfig.compileSdkVersion
}