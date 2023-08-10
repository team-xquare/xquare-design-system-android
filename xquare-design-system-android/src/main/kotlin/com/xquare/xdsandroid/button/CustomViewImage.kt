package com.xquare.xdsandroid.button

import androidx.annotation.ColorInt
import androidx.annotation.StyleableRes

interface CustomViewImage {
    fun setDrawableAttrs()
    fun getTint(
        @StyleableRes styleable: Int,
        @ColorInt color: Int,
    ): Int
    fun setLeadingSrc()
    fun setTrailingSrc()
}
