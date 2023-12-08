import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-library`
    `java-gradle-plugin`
    id("com.google.devtools.ksp") version "1.9.0-1.0.11"
    kotlin("jvm") version "1.9.0"
}

gradlePlugin {
    plugins {
        register("AndroidCoreLibraryPlugin") {
            id = "android.core.library.plugin"
            implementationClass = "commons.AndroidCoreLibraryPlugin"
        }
    }
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven("https://jitpack.io" )
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    ksp("io.arrow-kt:arrow-optics-ksp-plugin:1.2.0")
    implementation("com.android.tools.build:gradle:8.1.4")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation(kotlin("stdlib-jdk8"))
}