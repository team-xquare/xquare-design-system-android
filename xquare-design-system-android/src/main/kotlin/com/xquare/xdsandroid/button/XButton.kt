package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.ViewDefaults

public class XButton : AppCompatButton, InitializableView, Typable, InitializableDrawable {

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
        val leadingSrc = getLeadingSrc()
        val trailingSrc = getTrailingSrc()
        setCompoundDrawables(leadingSrc, null, trailingSrc, null)
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_button_small).toInt()
    }

    override fun getLeadingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_leadingSrc)?.apply {
            setBounds(0, 0, this.intrinsicWidth, this.intrinsicHeight)
            DrawableCompat.wrap(this).setTint(
                attributes.getColor(R.styleable.XButton_leadingSrcTint, R.attr.leadingSrcTint),
            )
        }
    }

    override fun getTrailingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            setBounds(0, 0, this.intrinsicWidth, this.intrinsicHeight)
            DrawableCompat.wrap(this).setTint(
                attributes.getColor(R.styleable.XButton_trailingSrcTint, R.attr.trailingSrcTint),
            )
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(
            attributes.getBoolean(
                R.styleable.XButton_android_enabled,
                true,
            ),
        )

        if (!enabled) {
            alpha = ViewDefaults.VIEW_DISABLED
        }
        isEnabled = enabled
    }
}
