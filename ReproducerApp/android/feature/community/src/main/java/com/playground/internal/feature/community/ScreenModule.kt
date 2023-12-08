package com.playground.internal.feature.community

import cafe.adriel.voyager.core.registry.screenModule
import com.playground.internal.common.navigation.SharedScreen

val chatScreen = ChatScreen()

val featureCommunityScreenModule = screenModule {
    register<SharedScreen.CommunityScreen> { provider ->
        chatScreen
    }
}