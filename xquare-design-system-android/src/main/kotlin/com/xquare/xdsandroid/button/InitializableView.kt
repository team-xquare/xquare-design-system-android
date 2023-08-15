package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import androidx.annotation.StyleableRes
import com.xquare.xdsandroid.ViewDefaults

internal interface InitializableView {

    var attributes: TypedArray

    fun initView(
        context: Context,
        attrs: AttributeSet?,
        @StyleableRes styleableRes: IntArray,
    ) {
        attributes = context.obtainStyledAttributes(attrs, styleableRes)
        setAttrs()
        attributes.recycle()
    }

    fun setAttrs()
    fun View.setIsEnabled(alpha: Float = ViewDefaults.ALPHA_DISABLED)
}
