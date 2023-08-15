package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
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
    TrailingDrawable,
    InitializableDrawable {

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
        setIsEnabled()
    }

    override fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean,
        includeFontPadding: Boolean,
    ) {
        this.text = text

        val textAppearance = attributes.getResourceId(
            R.styleable.XButton_android_textAppearance,
            R.style.BodyLarge,
        )

        val textStyle = ResourcesCompat.getFont(
            context,
            attributes.getResourceId(
                R.styleable.XButton_android_textStyle,
                R.font.notosans_medium,
            ),
        )

        val textColor = attributes.getColor(
            R.styleable.XButton_android_textColor,
            androidx.appcompat.R.attr.colorPrimary,
        )

        typeface = textStyle
        setTextAppearance(textAppearance)
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
            val width = attributes.getDimension(
                R.styleable.XButton_leadingSrcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.XButton_leadingSrcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.XButton_leadingSrcTint,
                R.attr.leadingSrcTint,
            )

            this.setBounds(0, 0, width, height)

            DrawableCompat.wrap(this).setTint(tint)
        }
    }

    override fun getTrailingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XButton_trailingSrc)?.apply {
            val width = attributes.getDimension(
                R.styleable.XButton_trailingSrcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.XButton_trailingSrcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.XButton_trailingSrcTint,
                R.attr.trailingSrcTint,
            )

            this.setBounds(0, 0, width, height)

            DrawableCompat.wrap(this).setTint(tint)
        }
    }

    override fun View.setIsEnabled(alpha: Float) {
        if (!isEnabled) {
            this.alpha = alpha
        }
    }
}
