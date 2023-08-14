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
        setTextAttrs(attributes.getText(R.styleable.XButton_android_text))
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

        val textStyle = attributes.getResourceId(
            R.styleable.XButton_textStyle,
            R.style.BodyLarge,
        )

        val textColor = attributes.getColor(
            R.styleable.XButton_android_textColor,
            androidx.appcompat.R.attr.colorPrimary,
        )

        setTextAppearance(textStyle)
        setTextColor(textColor)

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
            val leadingSrcWidth = attributes.getDimension(
                R.styleable.XButton_leadingSrcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val leadingSrcHeight = attributes.getDimension(
                R.styleable.XButton_leadingSrcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val leadingSrcTint = attributes.getColor(
                R.styleable.XButton_leadingSrcTint,
                R.attr.leadingSrcTint,
            )

            setBounds(0, 0, leadingSrcWidth, leadingSrcHeight)

            DrawableCompat.wrap(this).setTint(leadingSrcTint)
        }
    }

    override fun getTrailingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            val trailingSrcWidth = attributes.getDimension(
                R.styleable.XButton_trailingSrcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val trailingSrcHeight = attributes.getDimension(
                R.styleable.XButton_trailingSrcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val trailingSrcTint = attributes.getColor(
                R.styleable.XButton_trailingSrcTint,
                R.attr.trailingSrcTint,
            )

            setBounds(0, 0, trailingSrcWidth, trailingSrcHeight)

            DrawableCompat.wrap(this).setTint(trailingSrcTint)
        }
    }

    override fun setIsEnabled(enabled: Boolean) {
        if (!enabled) {
            alpha = ViewDefaults.VIEW_DISABLED
        }
        isEnabled = enabled
    }
}
