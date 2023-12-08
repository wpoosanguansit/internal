package com.playground.internal.navigation

import cafe.adriel.voyager.core.screen.Screen
import com.playground.internal.feature.community.chatScreen
import com.playground.internal.feature.udine4me.udine4MeScreen
import com.playground.internal.mainScreen


enum class ScreenInstance(val screen: Screen) {
    MAIN(mainScreen),
    UDINE4ME(udine4MeScreen),
    COMMUNITY(chatScreen)
}