package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.StyleableRes
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.ButtonConstants
import com.xquare.xdsandroid.R

public class XButton : AppCompatButton, CustomViewBase, CustomViewText, CustomViewImage {

    public constructor(context: Context) : this(
        context = context,
        attrs = null,
    )

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

    override fun initView(
        context: Context,
        attrs: AttributeSet?,
    ) {
        attributes = context.obtainStyledAttributes(attrs, R.styleable.XButton)
        setAttrs()
        attributes.recycle()
    }

    override fun setAttrs() {
        setTextAttrs()
        setDrawableAttrs()
        stateListAnimator = null
        setIsEnabled()
    }

    override fun setTextAttrs() {
        text = attributes.getText(R.styleable.XButton_android_text)
        setTextAppearance(
            attributes.getResourceId(
                R.styleable.XButton_android_textAppearance,
                R.style.BodyLarge,
            ),
        )
        setTextColor(
            attributes.getColor(
                R.styleable.XButton_android_textColor,
                androidx.appcompat.R.attr.colorPrimary,
            ),
        )
        isAllCaps = false
        includeFontPadding = false
    }

    override fun setDrawableAttrs() {
        setLeadingSrc()
        setTrailingSrc()
        setCompoundDrawables(leadingSrc, null, trailingSrc, null)
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_button_small).toInt()
    }

    override fun setLeadingSrc() {
        leadingSrc = attributes.getDrawable(R.styleable.XButton_leadingSrc)?.apply {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)

            val leadingTint = getTint(R.styleable.XButton_leadingSrcTint, R.attr.leadingSrcTint)

            DrawableCompat.wrap(this).setTint(leadingTint)
        }
    }

    override fun setTrailingSrc() {
        trailingSrc = attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)

            val trailingTint = getTint(R.styleable.XButton_trailingSrcTint, R.attr.trailingSrcTint)

            DrawableCompat.wrap(this).setTint(trailingTint)
        }
    }

    override fun getTint(
        @StyleableRes styleable: Int,
        @ColorInt color: Int,
    ): Int {
        return attributes.getColor(styleable, color)
    }

    override fun setIsEnabled() {
        val buttonEnabled = attributes.getBoolean(R.styleable.XButton_android_enabled, true)

        if (!buttonEnabled) {
            alpha = ButtonConstants.BUTTON_DISABLED
        }

        isEnabled = buttonEnabled
    }
}
