package com.xquare.xds.chip

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.xquare.xds.constant.ChipConstants
import com.xquare.xquare_design_system_android.R

public class XChip : AppCompatButton {
    public constructor(context: Context) : super(context) {
        initView(
            context = context, attrs = null
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
        val inflater = context?.applicationContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(
            /* resource = */ R.layout.chip,
            /* root = */ this,
        )
        typedArray = context.obtainStyledAttributes(
            /* set = */ attrs,
            /* attrs = */ R.styleable.XdsChip,
        )
    }


    @SuppressLint("ResourceAsColor")
    private fun setAttrs() {
        text = attributes.getText(R.styleable.XChip_android_text)
        setTextAppearance(R.style.BodyMedium)
        isAllCaps = false
        includeFontPadding = false
        compoundDrawablePadding = resources.getDimension(R.dimen.padding_chip_small).toInt()
        setChipEnabled()
        setSrc()

    }

    private fun setSrc() {
        val leadingSrc = attributes.getDrawable(R.styleable.XChip_leadingSrc)
        val trailingSrc = attributes.getDrawable(R.styleable.XChip_trailingSrc)

    private fun setTextColor() {
        textView.setTextColor(
            typedArray.getColor(
                R.styleable.XChip_android_textColor,
                resources.getColor(R.color.black)
            )
        )
    }

    private fun setIconImage() {
        val iconDrawable = typedArray.getDrawable(R.styleable.XChip_iconImage)
        if (iconDrawable == null) {
            iconImageView.visibility = View.GONE
        } else {
            iconImageView.setImageDrawable(iconDrawable)
        }

    private fun setBackground() {
        background = typedArray.getDrawable(R.styleable.XChip_android_background)
    }

    private fun setEnabled() {
        if (!typedArray.getBoolean(
                /* index = */ R.styleable.XdsChip_android_enabled,
                /* defValue = */ true,
            )
        ) {
            alpha = 0.4f
        }

        setCompoundDrawables(leadingSrc, null, trailingSrc, null)
    }

    private fun setDropDownImage() {
        val dropDownIcon = typedArray.getDrawable(R.styleable.XChip_dropDownIcon)
        if (dropDownIcon == null) {
            dropDownImageView.visibility = View.GONE
        } else {
            dropDownImageView.setImageDrawable(dropDownIcon)
        }

        isEnabled = chipEnabled
    }
}
