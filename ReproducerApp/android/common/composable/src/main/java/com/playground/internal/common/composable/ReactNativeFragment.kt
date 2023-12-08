package com.playground.internal.feature.community

import com.facebook.react.ReactFragment

class ReactNativeFragment : ReactFragment() {

    companion object {
        fun newInstance(componentName: String): ReactFragment {
            val fragment = Builder()
                .setComponentName(componentName)
                .setFabricEnabled(false)
                .build()
            return fragment
        }
    }
}