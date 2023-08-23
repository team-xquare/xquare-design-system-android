package com.xquare.xdsandroid.switch

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.util.setAlphaEnabled

public class XSwitch(
    context: Context,
    attrs: AttributeSet?,
) : SwitchCompat(context, attrs),
    InitializableView,
    InitializableDrawable {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XSwitch)
    }

    override fun setAttrs() {
        isAllCaps = false
        includeFontPadding = false
        stateListAnimator = null
        val isEnabled = attributes.getBoolean(R.styleable.XSwitch_android_enabled, true)
        setAlphaEnabled(isEnabled)
        setDrawable()
    }

    override fun setDrawable() {
        trackDrawable = attributes.getDrawable(R.styleable.XSwitch_android_track)
        thumbDrawable = attributes.getDrawable(R.styleable.XSwitch_android_thumb)
    }
}