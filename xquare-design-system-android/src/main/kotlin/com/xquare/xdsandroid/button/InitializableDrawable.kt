package com.xquare.xdsandroid.button

import android.graphics.drawable.Drawable

interface InitializableDrawable {
    fun getLeadingSrc(): Drawable?
    fun getTrailingSrc(): Drawable?
}
