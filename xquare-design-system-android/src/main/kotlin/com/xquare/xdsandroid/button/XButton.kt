package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.xquare.xdsandroid.ButtonConstants
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
            R.styleable.XButton,
        )
        setAttrs()
    }

    private fun setAttrs() {
        text = attributes.getText(R.styleable.XButton_android_text)
        stateListAnimator = null
        isAllCaps = false
        compoundDrawablePadding = resources.getDimension(R.dimen.button_padding_small).toInt()
        includeFontPadding = false
        setTextAppearance(R.style.BodyLarge)
        setSrc()
        setButtonEnabled()
    }

    private fun setSrc() {
        val leadingSrc = attributes.getDrawable(R.styleable.XButton_leadingSrc)
        val trailingSrc = attributes.getDrawable(R.styleable.XButton_trailingSrc)

        leadingSrc?.run {
            setBounds(
                0,
                0,
                intrinsicWidth,
                intrinsicHeight,
            )
        }

        trailingSrc?.run {
            setBounds(
                0,
                0,
                intrinsicWidth,
                intrinsicHeight,
            )
        }

        setCompoundDrawables(
            leadingSrc,
            null,
            trailingSrc,
            null,
        )
    }

    private fun setButtonEnabled() {

        val buttonEnabled = attributes.getBoolean(R.styleable.XButton_android_enabled, true)

        if(!buttonEnabled){
            alpha = ButtonConstants.ButtonDisabled
        }

        isEnabled = buttonEnabled
    }
}
