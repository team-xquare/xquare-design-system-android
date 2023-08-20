package com.xquare.xdsandroid.util

import android.view.View
import com.xquare.xdsandroid.ViewDefaults

object CustomViewUtil {
    fun View.setAlphaEnabled() {
        if (isEnabled) {
            this.alpha = ViewDefaults.ALPHA_DISABLED
        }
    }
}
