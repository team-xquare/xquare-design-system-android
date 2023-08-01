package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.xquare.xdsandroid.Constant
import com.xquare.xdsandroid.R

public class XButton : AppCompatButton {

    public constructor(context: Context) : super(context) {
        initView(
            context = context,
            attrs = null,
        )
    }

    public constructor(
        context: Context,
        attrs: AttributeSet? = null,
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
            R.styleable.XButton
        )
        setAttrs()
    }

    private fun setAttrs() {
        setText()
        setTextStyle()
        setSrc()
        setEnabled()
    }

    private fun setText() {
        text = attributes.getText(R.styleable.XButton_android_text)
    }

    private fun setTextStyle() {
        setTextAppearance(R.style.BodyLarge)
    }

    private fun setSrc() {
        val leadingSrc = attributes.getDrawable(R.styleable.XButton_leadingSrc)
        val trailingSrc = attributes.getDrawable(R.styleable.XButton_trailingSrc)

        leadingSrc?.setBounds(
            0,
            0,
            leadingSrc.intrinsicWidth,
            leadingSrc.intrinsicHeight,
        )
        trailingSrc?.setBounds(
            0,
            0,
            trailingSrc.intrinsicWidth,
            trailingSrc.intrinsicHeight,
        )

        setCompoundDrawables(
            leadingSrc,
            null,
            trailingSrc,
            null,
        )
    }

    private fun setEnabled() {
        if (
            !attributes.getBoolean(
                R.styleable.XButton_android_enabled,
                true,
            )
        ) {
            alpha = Constant.Disabled
        }
    }
}
