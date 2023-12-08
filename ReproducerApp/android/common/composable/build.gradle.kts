plugins {
    id("plugin.android-common")
}


dependencies {
    COMMON_THEME
    CORE
}

android {
    namespace = "com.playground.internal.common.composable"
    compileSdkVersion = AppConfig.compileSdkVersion
    buildFeatures {
        viewBinding = true
    }
}