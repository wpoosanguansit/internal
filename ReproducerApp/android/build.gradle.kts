buildscript {
  val agp_version by extra("8.1.4")
  dependencies {
    classpath(
        "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    classpath("com.android.tools.build:gradle:$agp_version")
    classpath("com.facebook.react:react-native-gradle-plugin")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
  }
  repositories {
    google()
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
  }
}

plugins {
  id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
  id("com.android.library") // version "8.1.4" apply false
  id("org.jetbrains.kotlin.android") // version "1.8.10" apply false
  id("com.ncorti.ktfmt.gradle") version "0.15.1"
  id("com.facebook.react.rootproject")
}

android {
  namespace = "com.playground.internal"
  compileSdkVersion = AppConfig.compileSdkVersion
  defaultConfig {
    testApplicationId = "com.plyground.internal.test"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    testHandleProfiling = true
    testFunctionalTest = true
  }
  version = "0.0.1"
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  buildToolsVersion = AppConfig.buildToolVersion
  ndkVersion = AppConfig.ndkVersion
}

ktfmt { removeUnusedImports.set(true) }

configurations.all { resolutionStrategy.force("junit:junit:4.13") }

val jvmVersion: Provider<String> = providers.gradleProperty("kotlin.jvm.target")

configure(subprojects) {
  // Apply compileOptions to subprojects
  plugins.withType<com.android.build.gradle.BasePlugin>().configureEach {
    extensions.findByType<com.android.build.gradle.BaseExtension>()?.apply {
      jvmVersion
          .map { JavaVersion.toVersion(it) }
          .orNull
          ?.let {
            compileOptions {
              sourceCompatibility = it
              targetCompatibility = it
            }
          }
    }
  }

  // Apply kotlinOptions.jvmTarget to subprojects
  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
      if (jvmVersion.isPresent) jvmTarget = jvmVersion.get()
      freeCompilerArgs += listOf("-Xskip-metadata-version-check", "-Xcontext-receivers")
    }
  }
}

allprojects {
  configurations.all { resolutionStrategy {
      force("androidx.fragment:fragment-ktx:${Version.FragmentVersion}")
  }}
}
