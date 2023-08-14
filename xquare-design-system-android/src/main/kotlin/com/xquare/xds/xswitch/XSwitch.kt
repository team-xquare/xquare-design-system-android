package com.xquare.xds.xswitch

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import com.xquare.xds.constant.SwitchConstants
import com.xquare.xquare_design_system_android.R

public class XSwitch : SwitchCompat {
    public constructor(context: Context) : this(context, null)

    public constructor(
        context: Context,
        attrs: AttributeSet?,
    ) : super(context, attrs) {
        init(context, attrs)
    }

    private lateinit var attributes: TypedArray

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
        trackDrawable = attributes.getDrawable(R.styleable.XSwitch_android_track)
        thumbDrawable = attributes.getDrawable(R.styleable.XSwitch_android_thumb)
    }

    private fun setSwitchEnabled() {
        val switchEnabled = attributes.getBoolean(R.styleable.XSwitch_android_enabled, true)

        if (!switchEnabled) {
            alpha = SwitchConstants.SWITCH_DISABLED
        }

        isEnabled = switchEnabled
    }
}
