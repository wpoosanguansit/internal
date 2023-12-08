package plugin

import AppConfig
import baseDependencies
import composeDependencies
import testDependencies


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.parcelize")
    kotlin("kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultConfig {
        minSdk = AppConfig.minSdk
        consumerProguardFiles ("consumer-rules.pro")
    }

    buildTypes {
        testBuildType = "debug"
        debug {}
        release {}
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.KotlinCompilerExtension
    }

    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    libraryVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir(File("build/generated/ksp/$name/kotlin"))
            }
        }
    }
}
kapt {
    correctErrorTypes = true
}
dependencies {
    baseDependencies()
    composeDependencies()
    testDependencies()
}




