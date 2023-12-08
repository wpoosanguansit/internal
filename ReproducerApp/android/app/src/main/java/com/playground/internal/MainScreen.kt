package com.playground.internal

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.playground.internal.common.navigation.SharedScreen
import com.playground.internal.navigation.BottomBar
import kotlinx.coroutines.CoroutineScope

val mainScreen = MainScreen()

class MainScreen: Screen {

    @OptIn(ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
    @Composable
    override fun Content() {
        Log.i("com.playground.internal", "MainScreen -------+---")

        val coroutineScope: CoroutineScope = rememberCoroutineScope()
        val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val homeScreen: Screen = rememberScreen(SharedScreen.uDine4MeScreen)

        Navigator(homeScreen) { navigator ->
            ModalNavigationDrawer(
                drawerContent = {
                },
                drawerState = drawerState,
                gesturesEnabled =  drawerState.isOpen
            ) {
                 Scaffold(
                    contentWindowInsets = WindowInsets(left = 0, top = 0, right = 0, bottom = 0),
                    topBar = {
                    },
                    bottomBar = {
                        BottomBar(currentScreen = navigator.lastItem, isDarkTheme = true)
                    }
                ) { paddings ->
                    Log.i(
                        "com.playground.internal",
                        "MainScreen padding bottom ${paddings.calculateBottomPadding()} ----"
                    )
                    CurrentScreen()
                }
            }
        }
    }
}