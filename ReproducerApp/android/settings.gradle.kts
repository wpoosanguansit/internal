pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io" )
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

rootProject.name = "Internal"
include(":app")
include(":core")
include(":common:theme")
include(":common:composable")
include(":feature:udine4me")
include(":feature:community")

apply(file("../node_modules/@react-native-community/cli-platform-android/native_modules.gradle"));
val applyNativeModulesSettingsGradle: groovy.lang.Closure<Any> by extra
applyNativeModulesSettingsGradle(settings)
includeBuild("../node_modules/@react-native/gradle-plugin")

