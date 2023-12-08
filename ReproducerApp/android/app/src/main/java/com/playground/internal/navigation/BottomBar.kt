package com.playground.internal.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.puskal.tiktokcompose.navigation.BottomBarDestination

@Composable
fun BottomBar(
    currentScreen: Screen?,
    isDarkTheme: Boolean
) {
    NavigationBar(
        modifier = Modifier
            .height(46.dp)
            .shadow(elevation = 16.dp)
            .padding(top = 2.dp),
        containerColor = Color.Transparent
    ) {
        BottomBarDestination.values().asList().forEach {
            BottomItem(it, isDarkTheme)
        }
    }
}

@Composable
fun RowScope.BottomItem(
    destination: BottomBarDestination,
    isDarkTheme: Boolean
) {
    val navigator = LocalNavigator.currentOrThrow
    Log.i("com.playground.internal", "BottomItem navigator?.lastItem ${navigator.lastItem} -----")
    val isCurrentBottomItemSelected = destination.route == navigator?.lastItem ?: false

    val (iconSize, offsetY) = Pair(28.dp, 0.dp)

    var icon: Int = if (isCurrentBottomItemSelected) destination.filledIcon else destination.unFilledIcon

    NavigationBarItem(
        modifier = Modifier
            .background(Color.Transparent),
        label = { },
        icon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                Modifier
                    .align(Alignment.CenterVertically)
                    .drawBehind {
                        drawRoundRect(
                            Color(0x60F5F5F0),
                            cornerRadius = CornerRadius(20.dp.toPx())
                        )
                    },
                tint = Color.Unspecified,
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.White,
            selectedIconColor = MaterialTheme.colorScheme.secondary,
            selectedTextColor = MaterialTheme.colorScheme.secondary
        ),
        selected = isCurrentBottomItemSelected,
        onClick = {
            Log.i("com.playground.internal", "bottombar onClick -----")
            if (destination.route == ScreenInstance.UDINE4ME.screen) {
                navigator.popUntilRoot()
            } else {
                navigator.push(destination.route)
            }

        }
    )
}