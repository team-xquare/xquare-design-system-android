package com.xquare.xdsandroid.button

import android.content.Context
import android.util.AttributeSet

interface ButtonBase {
    fun initView(
        context: Context,
        attrs: AttributeSet?,
    )

    fun setAttrs()
    fun setIsEnabled()
}
