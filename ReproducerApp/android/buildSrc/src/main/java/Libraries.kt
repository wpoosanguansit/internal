import Version.AndroidXAnnotationVersion
import Version.AndroidXEspressoCoreVersion
import Version.AndroidXTestVersion
import Version.AndroidXViewModelLifeCycleVersion
import Version.AppCompat
import Version.ArrowVersion
import Version.CameraXVersion
import Version.ComposeFormVersion
import Version.ComposeSettingsVersion
import Version.ComposeVersion
import Version.ConstraintLayoutCompose
import Version.CoreKtx
import Version.CoroutineVersion
import Version.DataBindingRuntimeVersion
import Version.FirebaseAnalyticsVersion
import Version.FirebaseAuthUiVersion
import Version.FirebaseAuthVersion
import Version.ServiceAuthVersion
import Version.FirebaseBomVersion
import Version.FirebaseCommonVersion
import Version.FirebaseProtoliteVersion
import Version.FlipperVersion
import Version.FormBuilderVersion
import Version.FragmentVersion
import Version.ServicesLocationVersion
import Version.GsonVersion
import Version.GuavaAndroid
import Version.ImmutableCollectionsVersion
import Version.JunitExtKtx
import Version.KtorVersion
import Version.Media3
import Version.NavigationCompose
import Version.ReactAndroidVersion
import Version.ServicesMapVersion
import Version.SoLoaderVersion
import Version.SplashScreenApi
import Version.TestRulesVersion
import Version.TestRunnerVersion
import Version.TruthExt
import Version.UltronVersion
import Version.VoyagerVersion

/**
 * Created by Puskal Khadka on 3/14/2023.
 */
object Version {
    const val CoreKtx = "1.9.0"
    const val AppCompat = "1.6.1"
    const val ComposeBom = "2023.10.01"
    const val ComposeActivity = "1.8.0"
    const val NavigationCompose = "2.5.3"
    const val AndroidXTestVersion = "1.5.0"
    const val ComposeVersion = AppConfig.composeVersion
    const val FragmentVersion = "1.7.0-alpha07"
    const val EspressoCore = "3.5.1"
    const val TestRunnerVersion = "1.5.2"
    const val JunitExtKtx = "1.1.5"
    const val TruthExt = "1.5.0"
    const val Coil = "2.2.2"
    const val Media3 = "1.0.0-rc02"
    const val Accompanist = "0.33.2-alpha"
    const val SplashScreenApi = "1.1.0-alpha02"
    const val ConstraintLayoutCompose = "1.0.1"
    const val GsonVersion = "2.10.1"
    const val CameraXVersion = "1.3.0-alpha05"
    const val GuavaAndroid = "31.0.1-android"
    const val ArrowVersion = "2.0.0-SNAPSHOT"
    const val VoyagerVersion = "1.0.0-rc08"
    const val FirebaseBomVersion = "32.5.0"
    const val FirebaseAnalyticsVersion = "21.5.0"
    const val ServiceAuthVersion = "20.7.0"
    const val FirebaseAuthUiVersion = "8.0.2"
    const val FirebaseAuthVersion = "22.3.0"
    const val FirebaseCommonVersion = "20.4.2"
    const val FirebaseProtoliteVersion = "18.0.0"
    const val FormBuilderVersion = "1.0.7"
    const val ComposeSettingsVersion = "1.0.2"
    const val AndroidXAnnotationVersion = "1.7.0"
    const val AndroidXEspressoCoreVersion = "3.5.1"
    const val AndroidXViewModelLifeCycleVersion = "2.6.2"
    const val CoroutineVersion = "1.7.3"
    const val ComposeFormVersion = "0.2.3"
    const val ImmutableCollectionsVersion = "0.3.6"
    const val KtorVersion = "2.3.6"
    const val MapComposeVersion = "4.3.0"
    const val ServicesMapVersion = "18.2.0"
    const val ServicesLocationVersion = "21.0.1"
    const val ReactAndroidVersion = "0.73"
    const val FlipperVersion = "0.240.0"
    const val SoLoaderVersion = "0.10.5"
    const val UltronVersion = "2.3.0"
    const val TestRulesVersion = "1.5.0"
    const val DataBindingRuntimeVersion = "8.2.0"
}


object Libraries {
    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoroutineVersion}"
        const val androidCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoroutineVersion}"
    }
    object KotlinX {
        const val immutableCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${ImmutableCollectionsVersion}"
    }
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:$CoreKtx"
        const val appCompat = "androidx.appcompat:appcompat:$AppCompat"
        const val splashScreen = "androidx.core:core-splashscreen:$SplashScreenApi"
        const val annotation = "androidx.annotation:annotation:$AndroidXAnnotationVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:${AndroidXEspressoCoreVersion}"
        const val viewModelLifeCycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidXViewModelLifeCycleVersion}"
        const val lifeCycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidXViewModelLifeCycleVersion}"
    }

    object Compose {
        const val composeBom = "androidx.compose:compose-bom:${Version.ComposeBom}"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeMaterial3 = "androidx.compose.material3:material3"
        const val composeFoundation = "androidx.compose.foundation:foundation"
        const val composeRuntime = "androidx.compose.runtime:runtime"
        const val composeActivity = "androidx.activity:activity-compose:${Version.ComposeActivity}"
        const val composeUiUtil = "androidx.compose.ui:ui-util"
        const val constraintLayoutCompose =
            "androidx.constraintlayout:constraintlayout-compose:$ConstraintLayoutCompose"
        const val contrainstlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val constraintlayoutCore = "androidx.constraintlayout:constraintlayout-core:1.0.4"
        const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${ComposeVersion}"
        const val lifeCycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${AndroidXViewModelLifeCycleVersion}"
        const val cardView = "androidx.cardview:cardview:1.0.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${FragmentVersion}"
        const val fragmentKtxDebug = "androidx.fragment:fragment-testing:${FragmentVersion}"
        const val uiViewBinding = "androidx.compose.ui:ui-viewbinding:${ComposeVersion}"
        const val dataBindingRuntime = "androidx.databinding:databinding-runtime:${DataBindingRuntimeVersion}"
    }

    object Google {
        const val gson = "com.google.code.gson:gson:$GsonVersion"
        const val guava="com.google.guava:guava:$GuavaAndroid"
        const val firebaseBom = "com.google.firebase:firebase-bom:${FirebaseBomVersion}"
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${FirebaseAnalyticsVersion}"
        const val firebaseAuth = "com.google.firebase:firebase-auth:${FirebaseAuthVersion}"
        const val servicesAuth =  "com.google.android.gms:play-services-auth:${ServiceAuthVersion}"
        const val coroutinesPlayServices =  "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${CoroutineVersion}"
        const val firebaseAuthUi = "com.firebaseui:firebase-ui-auth:${FirebaseAuthUiVersion}"
        const val firebaseCommon = "com.google.firebase:firebase-common-ktx:${FirebaseCommonVersion}"
        const val firebaseProtolite = "com.google.firebase:protolite-well-known-types:${FirebaseProtoliteVersion}"
        const val mapsCompose = "com.google.maps.android:maps-compose:4.3.0"
        const val servicesMaps = "com.google.android.gms:play-services-maps:${ServicesMapVersion}"
        const val servicesLocation = "com.google.android.gms:play-services-location:${ServicesLocationVersion}"
    }

    object Accompanist {
        const val pager =
            "com.google.accompanist:accompanist-pager:0.29.2-rc"
        const val swiperefresh =
            "com.google.accompanist:accompanist-swiperefresh:${Version.Accompanist}"
        const val indicators =
            "com.google.accompanist:accompanist-pager-indicators:${Version.Accompanist}"
        const val systemuicontroller =
            "com.google.accompanist:accompanist-systemuicontroller:${Version.Accompanist}"
        const val webView = "com.google.accompanist:accompanist-webview:${Version.Accompanist}"
        const val navigationMaterial =
            "com.google.accompanist:accompanist-navigation-material:${Version.Accompanist}"
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:${Version.Accompanist}"
        const val permission =
            "com.google.accompanist:accompanist-permissions:${Version.Accompanist}"
    }

    object Naviagtion {
        const val navigationCompose = "androidx.navigation:navigation-compose:$NavigationCompose"
    }

    object Coil {
        const val coilCompose = "io.coil-kt:coil-compose:${Version.Coil}"
        const val coilVideo = "io.coil-kt:coil-video:${Version.Coil}"
    }

    object AudioVideo {
        const val exoplayer = "androidx.media3:media3-exoplayer:$Media3"
        const val expplayerDash = "androidx.media3:media3-exoplayer-dash:$Media3"
        const val media3Ui = "androidx.media3:media3-ui:$Media3"
    }

    object Test {
        const val testCoreKtx = "androidx.test:core-ktx:$AndroidXTestVersion"
        const val junitExtKtx = "androidx.test.ext:junit-ktx:$JunitExtKtx"
        const val junit = "junit:junit:4.+"
        const val testRules = "androidx.test:rules:${TestRulesVersion}"
        const val truthExt = "androidx.test.ext:truth:$TruthExt"
        const val runner = "androidx.test:runner:$TestRunnerVersion"
        const val ultron = "com.atiurin:ultron:${UltronVersion}"
        const val ultronAllure = "com.atiurin:ultron-allure:${UltronVersion}"
        const val ultronCompose = "com.atiurin:ultron-compose:${UltronVersion}"
    }


    object CameraX {
        const val cameraCore = "androidx.camera:camera-core:$CameraXVersion"
        const val camera2 = "androidx.camera:camera-camera2:$CameraXVersion"
        const val cameraLifecycle = "androidx.camera:camera-lifecycle:$CameraXVersion"
        const val cameraVideo = "androidx.camera:camera-video:$CameraXVersion"
        const val cameraView = "androidx.camera:camera-view:$CameraXVersion"
        const val CameraExt = "androidx.camera:camera-extensions:$CameraXVersion"
    }

    object Arrow {
        const val arrowCore = "io.arrow-kt:arrow-core:$ArrowVersion"
        const val arrowOptics = "io.arrow-kt:arrow-optics:$ArrowVersion"
        const val arrowSerializer = "io.arrow-kt:arrow-core-serialization:$ArrowVersion"
    }

    object Voyager {
        // Navigator
        const val voyagerNavigator = "cafe.adriel.voyager:voyager-navigator:$VoyagerVersion"

        // BottomSheetNavigator
        const val voyagerBottomSheetNavigator = "cafe.adriel.voyager:voyager-bottom-sheet-navigator:$VoyagerVersion"

        // TabNavigator
        const val voyagerTabNavigator = "cafe.adriel.voyager:voyager-tab-navigator:$VoyagerVersion"

        // Transitions
        const val voyagerTransition = "cafe.adriel.voyager:voyager-transitions:$VoyagerVersion"
    }

    object Form {
        const val formBuilder = "com.github.jkuatdsc:form-builder:${FormBuilderVersion}"
        const val composeForm = "com.github.benjamin-luescher:compose-form:${ComposeFormVersion}"
    }

    object Settings {
        const val composeSettings =
            "com.github.alorma:compose-settings-ui-m3:$ComposeSettingsVersion"
    }

    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:$KtorVersion"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$KtorVersion"
        const val jsonSerialization = "io.ktor:ktor-serialization-kotlinx-json:$KtorVersion"
        const val clientAndroid = "io.ktor:ktor-client-android:$KtorVersion"
        const val clientLogging = "io.ktor:ktor-client-logging:$KtorVersion"
    }

    object ReactNative {
        const val reactAndroid = "com.facebook.react:react-android:${ReactAndroidVersion}"
        const val flipper = "com.facebook.flipper:flipper:${FlipperVersion}"
        const val flipperNoop = "com.facebook.flipper:flipper-noop:${FlipperVersion}"
        const val soloader = "com.facebook.soloader:soloader:${SoLoaderVersion}"
    }
}


