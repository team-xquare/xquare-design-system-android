package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
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
        setIsEnabled(
            attributes.getBoolean(
                R.styleable.XButton_android_enabled,
                true,
            ),
        )
        typeface = ResourcesCompat.getFont(
            context,
            attributes.getResourceId(
                R.styleable.XButton_android_fontFamily,
                R.font.notosans_regular,
            ),
        )
    }

    override fun setTextAttrs() {
        text = attributes.getText(R.styleable.XButton_android_text)
        setTextAppearance(
            attributes.getResourceId(
                R.styleable.XButton_textStyle,
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
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_8).toInt()
    }

    override fun getLeadingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_leadingSrc)?.apply {
            setBounds(
                0,
                0,
                attributes.getInt(R.styleable.XButton_leadingSrcSize, this.intrinsicWidth),
                attributes.getInt(R.styleable.XButton_leadingSrcSize, this.intrinsicHeight),
            )
        }
    }

    override fun getTrailingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            setBounds(
                0,
                0,
                attributes.getInt(R.styleable.XButton_trailingSrcSize, this.intrinsicWidth),
                attributes.getInt(R.styleable.XButton_trailingSrcSize, this.intrinsicHeight),
            )
            DrawableCompat.wrap(this).setTint(
                attributes.getColor(R.styleable.XButton_trailingSrcTint, R.attr.trailingSrcTint),
            )
        }
    }

    override fun setIsEnabled(enabled: Boolean) {
        if (!enabled) {
            alpha = ViewDefaults.VIEW_DISABLED
        }
        isEnabled = enabled
    }
}
