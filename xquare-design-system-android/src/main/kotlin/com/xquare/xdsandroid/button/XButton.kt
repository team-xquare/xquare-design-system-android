package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.util.CustomViewUtil.setAlphaEnabled

public class XButton(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatButton(context, attrs),
    InitializableView,
    Typable,
    InitializableDrawable {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XButton)
    }

    override fun setAttrs() {
        setTextAttrs(attributes.getText(R.styleable.XButton_android_text))
        setDrawable()
        stateListAnimator = null
        setAlphaEnabled()
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_8).toInt()
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

    override fun setDrawable() {
        val leadingSrc: Drawable? = getLeadingSrc()
        val trailingSrc: Drawable? = getTrailingSrc()
        setCompoundDrawables(leadingSrc, null, trailingSrc, null)
    }

    private fun getLeadingSrc(): Drawable? {
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

            DrawableCompat.wrap(this@apply).setTint(tint)
        }
    }

    private fun getTrailingSrc(): Drawable? {
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

            DrawableCompat.wrap(this@apply).setTint(tint)
        }
    }
}
