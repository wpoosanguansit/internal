package com.playground.internal

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.Navigator
import com.facebook.react.ReactInstanceManager
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.playground.internal.common.theme.iDine4uTheme
import com.playground.internal.navigation.ScreenInstance

class MainActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

  lateinit var reactInstanceManager: ReactInstanceManager
  private val OVERLAY_PERMISSION_REQ_CODE = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    window.statusBarColor = Color.TRANSPARENT

    /** Get the reference to the ReactInstanceManager */
    reactInstanceManager = (application as MainApp).reactNativeHost.reactInstanceManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      window.setFlags(
          WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
          WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
    setContent {
      iDine4uTheme {
        Navigator(ScreenInstance.MAIN.screen)
      }
    }
  }

  @SuppressLint("MissingSuperCall")
  override fun onBackPressed() {
    supportFragmentManager.fragments.forEach { fragment ->
      if (fragment != null && fragment.isVisible) {
        with(fragment.childFragmentManager) {
          if (backStackEntryCount > 0) {
            popBackStack()
            return
          }
        }
      }
    }
    onBackPressedDispatcher.onBackPressed()
  }

  /*
   * Any activity that uses the ReactFragment or ReactActivty
   * Needs to call onHostPause() on the ReactInstanceManager
   */
  override fun onPause() {
    super.onPause()
    if (reactInstanceManager != null) {
      reactInstanceManager.onHostPause(this)
    }
  }

  /*
   * Same as onPause - need to call onHostResume
   * on our ReactInstanceManager
   */
  override fun onResume() {
    super.onResume()
    if (reactInstanceManager != null) {
      reactInstanceManager.onHostResume(this, this)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    if (reactInstanceManager != null) {
      reactInstanceManager.onHostDestroy(this)
    }
  }

  // Open the React Native Developer Menu when you press the hardware menu button (use Ctrl + M in
  // Android Studio)
  override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
    if (keyCode == KeyEvent.KEYCODE_MENU && reactInstanceManager != null) {
      reactInstanceManager.showDevOptionsDialog()
      return true
    }
    return super.onKeyUp(keyCode, event)
  }

  override fun invokeDefaultOnBackPressed() {
    onBackPressedDispatcher.onBackPressed()
  }
}
