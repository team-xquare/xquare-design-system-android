package com.xquare.xdsandroid.chip

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.common.Typable
import com.xquare.xdsandroid.util.setAlphaEnabled

public class XChip(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatButton(context, attrs), InitializableView, Typable, InitializableDrawable {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XChip)
    }

    override fun setAttrs() {
        val text = attributes.getText(R.styleable.XChip_android_text)
        val isEnabled = attributes.getBoolean(R.styleable.XChip_android_enabled, true)
        setTextAttrs(text)
        stateListAnimator = null
        setDrawable()
        setAlphaEnabled(isEnabled)
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_4).toInt()
    }

    override fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean,
        includeFontPadding: Boolean,
    ) {
        this.text = text

        val textAppearance = attributes.getResourceId(
            R.styleable.XChip_android_textAppearance,
            R.style.LabelMedium,
        )

        val textStyle = ResourcesCompat.getFont(
            context,
            attributes.getResourceId(
                R.styleable.XChip_android_textStyle,
                R.font.notosans_regular,
            ),
        )

        val textColor = attributes.getColor(
            R.styleable.XChip_android_textColor,
            com.google.android.material.R.attr.colorOnSecondary,
        )

        val textAlign = attributes.getInt(R.styleable.XChip_android_textAlignment, 0)

        typeface = textStyle
        setTextAppearance(textAppearance)
        setTextColor(textColor)

        this.textAlignment = textAlign
        this.isAllCaps = isAllCaps
        this.includeFontPadding = includeFontPadding
    }

    override fun setDrawable() {
        val leadingSrc: Drawable? = getLeadingSrc()
        val trailingSrc: Drawable? = getTrailingSrc()
        val backgroundSrc: Drawable? = setBackground() ?: AppCompatResources.getDrawable(
            context,
            R.drawable.bg_chip_filled_enabled,
        )

        background = backgroundSrc
        setCompoundDrawables(leadingSrc, null, trailingSrc, null)
    }

    private fun getLeadingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XChip_leadingSrc)?.apply {
            val width = attributes.getDimension(
                R.styleable.XChip_leadingSrcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.XChip_leadingSrcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.XChip_leadingSrcTint,
                com.google.android.material.R.attr.colorOnSecondary,
            )

            this.setBounds(0, 0, width, height)
            DrawableCompat.wrap(this@apply).setTint(tint)
        }
    }

    private fun getTrailingSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XChip_trailingSrc)?.apply {
            val width = attributes.getDimension(
                R.styleable.XChip_trailingSrcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.XChip_trailingSrcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.XChip_trailingSrcTint,
                com.google.android.material.R.attr.colorOnSecondary,
            )

            this.setBounds(0, 0, width, height)
            DrawableCompat.wrap(this@apply).setTint(tint)
        }
    }

    private fun setBackground(): Drawable? {
        return attributes.getDrawable(R.styleable.XChip_android_background)
    }
}
