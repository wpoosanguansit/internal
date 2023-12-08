package com.playground.internal.feature.udine4me

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import com.facebook.react.ReactFragment
import com.playground.internal.common.composable.FragmentAwareAndroidViewBinding
import com.playground.internal.common.theme.R
import com.playground.internal.common.theme.databinding.FragmentContainerBinding
import com.playground.internal.feature.community.ReactNativeFragment
import kotlinx.coroutines.launch
import java.util.UUID

class uDine4MeScreen : Screen {
  @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
  @Composable
  override fun Content() {
    val activity = LocalContext.current as FragmentActivity
    val tag = UUID.randomUUID().toString()
    val fragment: ReactFragment = ReactNativeFragment.newInstance("JazzApp")
    LifecycleEffect(
        onDisposed = {
            activity
                .getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .remove(fragment)
                .commitAllowingStateLoss()
        }
    )
    val bottomSheetScaffoldState =
        rememberBottomSheetScaffoldState(
            bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
          Box(Modifier.fillMaxWidth().height(200.dp).background(Color.Red)) {
            FragmentAwareAndroidViewBinding(
                R.layout.fragment_container, FragmentContainerBinding::inflate) {
                    val found = activity.supportFragmentManager.findFragmentByTag(tag)
                    found?.let {
                        activity
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .attach(fragment)
                            .commitAllowingStateLoss()
                    } ?: run {
                        activity
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.fragment_container_view, fragment, tag)
                            .commitAllowingStateLoss()
                    }

                }
          }
        },
        sheetPeekHeight = 0.dp) {
          Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                  coroutineScope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                      bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                      bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                  }
                }) {
                  Text(text = "Expand/Collapse Bottom Sheet")
                }
          }
        }
  }
}
