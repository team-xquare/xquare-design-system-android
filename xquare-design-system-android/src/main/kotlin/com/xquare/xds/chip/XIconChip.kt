package com.xquare.xds.chip

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import com.xquare.xds.constant.ChipConstants
import com.xquare.xquare_design_system_android.R

public class XIconChip : AppCompatImageButton {
    public constructor(context: Context) : super(context) {
        initView(
            context = context,
            attrs = null,
        )
    }

    public constructor(
        context: Context,
        attrs: AttributeSet?,
    ) : super(context, attrs) {
        initView(
            context = context,
            attrs = attrs,
        )
    }

    private lateinit var attributes: TypedArray

    private fun initView(
        context: Context,
        attrs: AttributeSet?,
    ) {
        attributes = context.obtainStyledAttributes(
            attrs, R.styleable.XIconChip
        )
        setAttrs()
    }

    private fun setAttrs() {
        setSrc()
        setIconChipEnabled()
    }

    private fun setSrc() {
        val src = attributes.getDrawable(R.styleable.XIconChip_android_src)
        setImageDrawable(src)
    }

    private fun setIconChipEnabled() {
        val iconChipEnabled = attributes.getBoolean(R.styleable.XIconChip_android_enabled, true)
        if (!iconChipEnabled) {
            alpha = ChipConstants.CHIP_DISABLED
        }

        isEnabled = iconChipEnabled
    }
}
