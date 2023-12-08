package com.playground.internal.common.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider


sealed class SharedScreen : ScreenProvider {
    object uDine4MeScreen : SharedScreen()
    object CommunityScreen : SharedScreen()
}
