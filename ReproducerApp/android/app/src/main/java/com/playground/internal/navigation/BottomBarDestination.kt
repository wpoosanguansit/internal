package com.puskal.tiktokcompose.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import cafe.adriel.voyager.core.screen.Screen
import com.playground.internal.common.theme.R
import com.playground.internal.navigation.ScreenInstance


enum class BottomBarDestination(
    val route: Screen,
    @StringRes val title: Int,
    @DrawableRes val unFilledIcon: Int,
    @DrawableRes val filledIcon: Int,
    @DrawableRes val darkModeIcon: Int? = null
) {
    uDINE4Me(
        route = ScreenInstance.UDINE4ME.screen,
        title = R.string.udine4me,
        unFilledIcon = R.drawable.ic_u_dine_4_me,
        filledIcon = R.drawable.ic_u_dine_4_me_selected
    ),
    SETTINGS(
        route = ScreenInstance.COMMUNITY.screen,
        title = R.string.settings,
        unFilledIcon = R.drawable.ic_settings,
        filledIcon = R.drawable.ic_settings_selected
    )

}