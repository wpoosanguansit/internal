package com.playground.internal.common.composable

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commitNow
import androidx.fragment.app.findFragment
import androidx.viewbinding.ViewBinding

@SuppressLint("ResourceType")
@Composable
fun <T : ViewBinding> FragmentAwareAndroidViewBinding(
    @LayoutRes resourceId: Int,
    bindingBlock: (LayoutInflater, ViewGroup, Boolean) -> T,
    modifier: Modifier = Modifier,
    update: T.() -> Unit = {}
) {
    val fragmentContainerViews = remember { mutableStateListOf<FragmentContainerView>() }
    val localView = LocalView.current
    AndroidViewBinding({ parentInflater, parent, attachToRoot ->
        // Find the right FragmentManager
        val inflater = try {
            val parentFragment = localView.findFragment<Fragment>()
            parentFragment.layoutInflater
        } catch (e: Exception) {
            parentInflater
        }
        bindingBlock(inflater, parent, attachToRoot)
    }, modifier = modifier) {
        fragmentContainerViews.clear()
        val rootGroup = root as? ViewGroup
        if (rootGroup != null) {
            findFragmentContainerViews(rootGroup, fragmentContainerViews)
        }
        update()
    }
    val activity = LocalContext.current as FragmentActivity
    fragmentContainerViews.forEach { container ->
        DisposableEffect(container) {
            // Find the right FragmentManager
            val fragmentManager = try {
                val parentFragment = container.findFragment<Fragment>()
                parentFragment.childFragmentManager
            } catch (e: Exception) {
                activity.supportFragmentManager
            }
            // Now find the fragment inflated via the FragmentContainerView
            val existingFragment = fragmentManager.findFragmentById(resourceId)
            onDispose {
                if (existingFragment != null && !fragmentManager.isStateSaved) {
                    // If the state isn't saved, that means that some state change
                    // has removed this Composable from the hierarchy
                    fragmentManager.commitNow(true) {
                        remove(existingFragment)
                    }
                }
            }
        }
    }
}
private fun findFragmentContainerViews(viewGroup: ViewGroup, list: SnapshotStateList<FragmentContainerView>) {
    viewGroup.forEach {
        if (it is FragmentContainerView) {
            list += it
        } else if (it is ViewGroup) {
            findFragmentContainerViews(it, list)
        }
    }
}