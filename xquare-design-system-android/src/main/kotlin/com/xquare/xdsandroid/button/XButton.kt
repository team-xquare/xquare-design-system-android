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

public class XButton(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatButton(context, attrs),
    InitializableView,
    Typable,
    LeadingDrawable,
    TrailingDrawable {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XButton)
    }

    override fun setAttrs() {
        setTextAttrs(
            text = attributes.getText(R.styleable.XButton_android_text),
            isAllCaps = false,
            includeFontPadding = false,
        )
        setDrawableAttrs()
        stateListAnimator = null
        typeface = ResourcesCompat.getFont(
            context,
            attributes.getResourceId(
                R.styleable.XButton_android_fontFamily,
                R.font.notosans_regular,
            ),
        )

        val isEnabled = attributes.getBoolean(R.styleable.XButton_android_enabled, true)
        setIsEnabled(isEnabled)
    }

    override fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean,
        includeFontPadding: Boolean,
    ) {
        this.text = text
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
        this.isAllCaps = isAllCaps
        this.includeFontPadding = includeFontPadding
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
                attributes.getDimension(
                    R.styleable.XButton_leadingSrcSize,
                    this.intrinsicWidth.toFloat(),
                ).toInt(),
                attributes.getDimension(
                    R.styleable.XButton_leadingSrcSize,
                    this.intrinsicHeight.toFloat(),
                ).toInt(),
            )
            DrawableCompat.wrap(this).setTint(
                attributes.getColor(R.styleable.XButton_leadingSrcTint, R.attr.leadingSrcTint),
            )
        }
    }

    override fun getTrailingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            setBounds(
                0,
                0,
                attributes.getDimension(
                    R.styleable.XButton_trailingSrcSize,
                    this.intrinsicWidth.toFloat(),
                ).toInt(),
                attributes.getDimension(
                    R.styleable.XButton_trailingSrcSize,
                    this.intrinsicHeight.toFloat(),
                ).toInt(),
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
