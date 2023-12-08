package com.playground.internal.feature.udine4me

import cafe.adriel.voyager.core.registry.screenModule
import com.playground.internal.common.navigation.SharedScreen

val udine4MeScreen: uDine4MeScreen = uDine4MeScreen()

val featureuDine4meScreenModule = screenModule {
    register<SharedScreen.uDine4MeScreen> {
        udine4MeScreen
    }
}