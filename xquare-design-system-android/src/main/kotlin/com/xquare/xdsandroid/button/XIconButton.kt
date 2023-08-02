package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import com.xquare.xdsandroid.ButtonConstants
import com.xquare.xdsandroid.R

public class XIconButton : AppCompatImageButton {

    public constructor(context: Context) : super(context) {
        initView(
            context = context,
            attrs = null,
        )
    }

    public constructor(
        context: Context,
        attrs: AttributeSet?,
    ) : super(
        context,
        attrs,
    ) {
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
            attrs,
            R.styleable.XIconButton,
        )
        setAttrs()
    }

    private fun setAttrs() {
        setSrc()
        setEnabled()
    }

    private fun setSrc() {
        val src = attributes.getDrawable(R.styleable.XIconButton_android_src)
        setImageDrawable(src)
    }

    private fun setEnabled() {
        if (!attributes.getBoolean(
                R.styleable.XButton_android_enabled,
                true,
            )
        ) {
            alpha = ButtonConstants.ButtonDisabled
        }
    }
}