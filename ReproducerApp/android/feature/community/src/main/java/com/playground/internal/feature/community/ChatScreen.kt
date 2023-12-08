package com.playground.internal.feature.community

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import cafe.adriel.voyager.core.screen.Screen
import com.playground.internal.common.composable.FragmentAwareAndroidViewBinding
import com.playground.internal.common.theme.R
import com.playground.internal.common.theme.databinding.FragmentChatBinding
import java.util.UUID
import com.facebook.react.ReactFragment
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect

class ChatScreen: Screen {
    @Composable
    override fun Content() {

        val activity = LocalContext.current as FragmentActivity
        val tag = UUID.randomUUID().toString()
        val fragment: ReactFragment = ReactNativeFragment.newInstance("JazzApp")
        LifecycleEffect(
            onDisposed = {
                Log.i("com.playground.internal", "chat fragment disposed ${tag}")
                activity
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .remove(fragment)
                    .commitAllowingStateLoss()
            }
        )
        Log.i("com.playground.internal", "ChatScreen -------+---")
        val paddingValues = WindowInsets.navigationBars.asPaddingValues()
        Log.i("com.playground.internal", "ChatScreen paddingValues bottom ${paddingValues.calculateBottomPadding()}-------+---")
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            FragmentAwareAndroidViewBinding(
                R.layout.fragment_chat, FragmentChatBinding::inflate) {
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
                            .add(R.id.fragment_chat_view, fragment, tag)
                            .commitAllowingStateLoss()
                    }

            }
        }
    }

}