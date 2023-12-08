plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.facebook.react")
}
/**
 * This is the configuration block to customize your React Native Android app.
 * By default you don't need to apply any configuration, just uncomment the lines you need.
 */
react {
    /* Folders */
    //   The root of your project, i.e. where "package.json" lives. Default is '..'
    // root = file("../")
    //   The folder where the react-native NPM package is. Default is ../node_modules/react-native
    // reactNativeDir = file("../node_modules/react-native")
    //   The folder where the react-native Codegen package is. Default is ../node_modules/@react-native/codegen
    // codegenDir = file("../node_modules/@react-native/codegen")
    //   The cli.js file which is the React Native CLI entrypoint. Default is ../node_modules/react-native/cli.js
    // cliFile = file("../node_modules/react-native/cli.js")

    /* Variants */
    //   The list of variants to that are debuggable. For those we're going to
    //   skip the bundling of the JS bundle and the assets. By default is just 'debug'.
    //   If you add flavors like lite, prod, etc. you'll have to list your debuggableVariants.
    // debuggableVariants = ["liteDebug", "prodDebug"]

    /* Bundling */
    //   A list containing the node command and its flags. Default is just 'node'.
    // nodeExecutableAndArgs = ["node"]
    //
    //   The command to run when bundling. By default is 'bundle'
    // bundleCommand = "ram-bundle"
    //
    //   The path to the CLI configuration file. Default is empty.
    // bundleConfig = file(../rn-cli.config.js)
    //
    //   The name of the generated asset file containing your JS bundle
    // bundleAssetName = "MyApplication.android.bundle"
    //
    //   The entry file for bundle generation. Default is 'index.android.js' or 'index.js'
    entryFile = file("../../index.ts")
    //
    //   A list of extra flags to pass to the 'bundle' commands.
    //   See https://github.com/react-native-community/cli/blob/main/docs/commands.md#bundle
    // extraPackagerArgs = []

    /* Hermes Commands */
    //   The hermes compiler command to run. By default it is 'hermesc'
    // hermesCommand = "$rootDir/my-custom-hermesc/bin/hermesc"
    //
    //   The list of flags to pass to the Hermes compiler. By default is "-O", "-output-source-map"
    // hermesFlags = ["-O", "-output-source-map"]
}

/**
 * Set this to true to Run Proguard on Release builds to minify the Java bytecode.
 */
val enableProguardInReleaseBuilds = false

/**
 * The preferred build flavor of JavaScriptCore (JSC)
 *
 * For example, to use the international variant, you can use:
 * `def jscFlavor = 'org.webkit:android-jsc-intl:+'`
 *
 * The international variant includes ICU i18n library and necessary data
 * allowing to use e.g. `Date.toLocaleString` and `String.localeCompare` that
 * give correct results when using with locales other than en-US. Note that
 * this variant is about 6MiB larger per architecture than default.
 */
val jscFlavor = "org.webkit:android-jsc:+"

android.buildFeatures.buildConfig = true

android {
    namespace = "com.playground.internal"
    compileSdk = 33
    ndkVersion = AppConfig.ndkVersion
    defaultConfig {
        applicationId = "com.playground.internal"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        versionCode = AppConfig.versionCode
        compileSdkPreview = "UpsideDownCake"
    }
    signingConfigs {
        defaultConfig {

        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            initWith(getByName("debug"))
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.KotlinCompilerExtension
    }
    buildToolsVersion = AppConfig.buildToolVersion
    ndkVersion = AppConfig.ndkVersion

    androidComponents.onVariants { variant ->
        val name = variant.name
        sourceSets {
            getByName(name).kotlin.srcDir("${layout.buildDirectory}/generated/ksp/${name}/kotlin")
        }
    }

    externalNativeBuild {
        cmake {
            path("src/main/jni/CMakeLists.txt")
        }
    }

    configurations.all {
        resolutionStrategy {
            force("androidx.fragment:fragment-ktx:${Version.FragmentVersion}")
        }
    }
}

dependencies {
    moduleDependencies()

//    val FLIPPER_VERSION: String by rootProject
//    debugImplementation("com.facebook.flipper:flipper:0.240.0")
//    debugImplementation("com.facebook.flipper:flipper-network-plugin:0.240.0") {
//        exclude(group = "com.squareup.okhttp3", module = "okhttp")
//    }
//
//    debugImplementation("com.facebook.flipper:flipper-fresco-plugin:${FLIPPER_VERSION}")

    debugImplementation(Libraries.ReactNative.soloader)
    debugImplementation(Libraries.ReactNative.flipper)
    releaseImplementation(Libraries.ReactNative.flipperNoop)
    debugImplementation("com.facebook.flipper:flipper-network-plugin:0.240.0") {
        exclude(group = "com.squareup.okhttp3", module = "okhttp")
    }

    val hermesEnabled: String by rootProject
    if (hermesEnabled.toBoolean()) {
        implementation("com.facebook.react:hermes-android")
    } else {
        implementation(jscFlavor)
    }
}

apply(from = "../../node_modules/@react-native-community/cli-platform-android/native_modules.gradle")
val applyNativeModulesAppBuildGradle: groovy.lang.Closure<Any> by extra
applyNativeModulesAppBuildGradle(project, null)
// https://github.com/microsoft/react-native-code-push/blob/df9f82b4db1219d609da1b28929b76dd91ae535d/docs/setup-android.md
//apply(from = "../../node_modules/react-native-code-push/android/codepush.gradle")
//apply(from = "../../node_modules/@sentry/react-native/sentry.gradle")