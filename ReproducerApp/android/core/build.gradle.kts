plugins {
    id("plugin.android-common")
}

dependencies {
    arrowsDependencies()
    voyagerDependencies()
    googleServiceDependencies()
    formDependencies()
    settingsDependencies()
    media3Dependency()
    baseDependencies()
    composeDependencies()
    testDependencies()
    baseDependencies()
    ktorDependencies()
    reactNativeDependencies()
}

android {
    namespace = "com.playground.internal.core"
    compileSdkVersion = AppConfig.compileSdkVersion
}