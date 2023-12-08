


import gradle.kotlin.dsl.accessors._e179bf612521bfe404cb5c212bae6188.api
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.composeDependencies() {
    api(platform(Libraries.Compose.composeBom))
    api(Libraries.Compose.composeActivity)
    api(Libraries.Compose.composeUi)
    api(Libraries.Compose.composeUiToolingPreview)
    api(Libraries.Compose.composeUiUtil)
    api(Libraries.Compose.composeFoundation)
    api(Libraries.Compose.composeRuntime)
    api(Libraries.Compose.composeMaterial3)
    api(Libraries.Compose.lifeCycleRuntimeCompose)
    api(Libraries.Compose.cardView)
    api(Libraries.Compose.fragmentKtx) { version {
        strictly(Version.FragmentVersion)
    }}
    api(Libraries.Compose.contrainstlayout)
    api(Libraries.Compose.constraintlayoutCore)
    api(Libraries.Compose.constraintLayoutCompose)
    api(Libraries.Compose.uiViewBinding)
    api(Libraries.Compose.dataBindingRuntime)
    debugImplementation(Libraries.Compose.fragmentKtxDebug)
//    implementation(Libraries.Compose.composeMaterialIconsExtended)

    //navgation
//    api(Libraries.Naviagtion.navigationCompose)

    //coil
    api(Libraries.Coil.coilCompose)
    api(Libraries.Coil.coilVideo)

    //accompanist
    accompanistDependencies()

    //constraint layout
    api(Libraries.Compose.constraintLayoutCompose)

//    api(Libraries.Compose.bottomSheetDialog)

}

fun DependencyHandler.coroutines() {
    implementation(Libraries.Coroutine.core)
    implementation(Libraries.Coroutine.androidCoroutine)
}

fun DependencyHandler.baseDependencies() {
    api(Libraries.AndroidX.appCompat)
    api(Libraries.AndroidX.coreKtx)
    api(Libraries.AndroidX.lifeCycleRuntimeKtx)
    api(Libraries.AndroidX.viewModelLifeCycle)
    api(Libraries.AndroidX.splashScreen)
    api(Libraries.KotlinX.immutableCollections)
}

fun DependencyHandler.accompanistDependencies() {
    api(Libraries.Accompanist.pager)
    api(Libraries.Accompanist.swiperefresh)
    api(Libraries.Accompanist.webView)
    api(Libraries.Accompanist.indicators)
    api(Libraries.Accompanist.systemuicontroller)
    api(Libraries.Accompanist.navigationMaterial)
    api(Libraries.Accompanist.navigationAnimation)
    api(Libraries.Accompanist.permission)
}

fun DependencyHandler.testDependencies() {
    api(Libraries.Test.junit)
    api(Libraries.Test.testCoreKtx)
    api(Libraries.Test.runner)
    api(Libraries.Test.junitExtKtx)
    api(Libraries.Test.testRules)
    api(Libraries.Test.truthExt)
    api(Libraries.Test.ultron)
    api(Libraries.Test.ultronAllure)
    api(Libraries.Test.ultronCompose)
}

fun DependencyHandler.media3Dependency() {
    api(Libraries.AudioVideo.exoplayer)
    api(Libraries.AudioVideo.expplayerDash)
    api(Libraries.AudioVideo.media3Ui)
}

fun DependencyHandler.cameraXDependencies() {
    implementation(Libraries.CameraX.cameraCore)
    implementation(Libraries.CameraX.camera2)
    implementation(Libraries.CameraX.cameraLifecycle)
    implementation(Libraries.CameraX.cameraVideo)
    implementation(Libraries.CameraX.cameraView)
    implementation(Libraries.CameraX.CameraExt)
}

fun DependencyHandler.arrowsDependencies() {
    api(Libraries.Arrow.arrowCore)
    api(Libraries.Arrow.arrowOptics)
    api(Libraries.Arrow.arrowSerializer)
}

fun DependencyHandler.voyagerDependencies() {
    api(Libraries.Voyager.voyagerNavigator)
    api(Libraries.Voyager.voyagerTransition)
    api(Libraries.Voyager.voyagerTabNavigator)
    api(Libraries.Voyager.voyagerBottomSheetNavigator)
}

fun DependencyHandler.formDependencies() {
    api(Libraries.Form.formBuilder)
}

fun DependencyHandler.settingsDependencies() {
    api(Libraries.Settings.composeSettings)
}

fun DependencyHandler.googleServiceDependencies() {
    api(Libraries.Google.firebaseAnalytics)
    api(Libraries.Google.firebaseAuth)
    api(Libraries.Google.firebaseBom)
    api(Libraries.Google.servicesAuth)
    api(Libraries.Google.firebaseCommon)
    api(Libraries.Google.mapsCompose)
    api(Libraries.Google.servicesLocation)
    api(Libraries.Google.servicesMaps)
}

fun DependencyHandler.ktorDependencies() {
    api(Libraries.Ktor.clientCore)
    api(Libraries.Ktor.clientAndroid)
    api(Libraries.Ktor.clientLogging)
    api(Libraries.Ktor.contentNegotiation)
    api(Libraries.Ktor.jsonSerialization)
}


fun DependencyHandler.reactNativeDependencies() {
    api(Libraries.ReactNative.reactAndroid)
}

fun DependencyHandler.moduleDependencies() {
    CORE
    COMMON_THEME
    COMMON_COMPOSABLE
    FEATURE_U_DINE_4_ME
    FEATURE_COMMUNITY
}


val DependencyHandler.CORE
    get() = implementation(project(mapOf("path" to ":core")))

val DependencyHandler.COMMON_COMPOSABLE
    get() = implementation(project(mapOf("path" to ":common:composable")))

val DependencyHandler.COMMON_THEME
    get() = implementation(project(mapOf("path" to ":common:theme")))

val DependencyHandler.FEATURE_U_DINE_4_ME
    get() = implementation(project(mapOf("path" to ":feature:udine4me")))

val DependencyHandler.FEATURE_COMMUNITY
    get() = implementation(project(mapOf("path" to ":feature:community")))


