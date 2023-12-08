plugins {
    id("plugin.android-common")
}


dependencies {

}

android {
    namespace = "com.playground.internal.common.theme"
    compileSdkVersion = AppConfig.compileSdkVersion
    buildFeatures {
        viewBinding = true
    }
}