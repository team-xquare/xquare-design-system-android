package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.ButtonConstants
import com.xquare.xdsandroid.R

public class XButton : AppCompatButton {

    public constructor(context: Context) : this(context, null)

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

    private var leadingSrc: Drawable? = null
    private var trailingSrc: Drawable? = null

    private fun initView(
        context: Context,
        attrs: AttributeSet?,
    ) {
        attributes = context.obtainStyledAttributes(attrs, R.styleable.XButton)
        setAttrs()
    }

    private fun setAttrs() {
        setTextAttrs()
        setDrawableAttrs()
        stateListAnimator = null
        setIsEnabled()
    }

    private fun setTextAttrs() {
        isAllCaps = false
        includeFontPadding = false
        text = attributes.getText(R.styleable.XButton_android_text)
        setTextAppearance(R.style.BodyLarge)
    }

    private fun setDrawableAttrs() {
        setLeadingSrc()
        setTrailingSrc()
        setCompoundDrawables(leadingSrc, null, trailingSrc, null)
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_button_small).toInt()
    }

    private fun setLeadingSrc() {
        leadingSrc = attributes.getDrawable(R.styleable.XButton_leadingSrc)?.apply {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)

            val leadingTint =
                attributes.getColor(R.styleable.XButton_leadingSrcTint, R.attr.leadingSrcTint)

            DrawableCompat.wrap(this).setTint(leadingTint)
        }
    }

    private fun setTrailingSrc() {
        trailingSrc = attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)

            val trailingTint =
                attributes.getColor(R.styleable.XButton_trailingSrcTint, R.attr.trailingSrcTint)

            DrawableCompat.wrap(this).setTint(trailingTint)
        }
    }

    private fun setIsEnabled() {
        val buttonEnabled = attributes.getBoolean(R.styleable.XButton_android_enabled, true)

        if (!buttonEnabled) {
            alpha = ButtonConstants.BUTTON_DISABLED
        }

        isEnabled = buttonEnabled
    }
}
