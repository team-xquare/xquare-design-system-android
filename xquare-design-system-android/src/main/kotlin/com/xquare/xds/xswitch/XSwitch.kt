package com.xquare.xds.xswitch

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import com.xquare.xds.constant.SwitchConstants
import com.xquare.xquare_design_system_android.R

class XSwitch : SwitchCompat {
    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private lateinit var attributes: TypedArray
    private var trackSrc: Drawable? = null
    private var thumbSrc: Drawable? = null

    private fun init(context: Context, attrs: AttributeSet?) {
        attributes = context.obtainStyledAttributes(attrs, R.styleable.XSwitch)
        setAttrs()
    }

    private fun setAttrs() {
        isAllCaps = false
        includeFontPadding = false
        setDrawableAttrs()
        stateListAnimator = null
        setSwitchEnabled()
    }

    private fun setDrawableAttrs() {
        trackSrc = attributes.getDrawable(R.styleable.XSwitch_android_track)
        thumbSrc = attributes.getDrawable(R.styleable.XSwitch_android_thumb)

        trackSrc?.let {
            trackDrawable = it
        }

        thumbSrc?.let {
            thumbDrawable = it
        }
    }

    private fun setSwitchEnabled() {
        val switchEnabled = attributes.getBoolean(R.styleable.XSwitch_android_enabled, true)

        if (!switchEnabled) {
            alpha = SwitchConstants.SWITCH_DISABLED
        }

        isEnabled = switchEnabled
    }
}
