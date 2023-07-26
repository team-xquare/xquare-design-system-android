package com.xquare.xds.chip

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import com.xquare.xquare_design_system_android.R

public class XChip @JvmOverloads public constructor(
    context: Context,
    attr: AttributeSet? = null,
    @StyleRes private val style: Int,
    @ColorRes private val color: Int = R.color.neutral_0,
) : LinearLayout(context, attr) {
    private lateinit var typedArray: TypedArray

    private val textView: TextView by lazy {
        this.findViewById(R.id.tv_xds_chip)
    }

    private val iconImageView: ImageView by lazy {
        this.findViewById(R.id.img_xds_chip_icon)
    }

    private val dropDownImageView: ImageView by lazy {
        this.findViewById(R.id.img_xds_chip_drop_down)
    }

    init {
        initView(
            context = context,
            attrs = attr,
        )
        setAttrs()
    }

    private fun initView(
        context: Context,
        attrs: AttributeSet? = null,
    ) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(
            /* resource = */ R.layout.chip,
            /* root = */ this,
        )
        typedArray = context.obtainStyledAttributes(
            /* set = */ attrs,
            /* attrs = */ R.styleable.XdsChip,
        )
    }

    private fun setAttrs() {
        setText()
        setTexColor()
        setTextStyle()
        setImage()
        setBackground()
        setEnabled()
        setDropDownImage()
    }

    private fun setText() {
        textView.text = typedArray.getText(R.styleable.XdsChip_android_text)
    }

    private fun setTexColor() {
        textView.setTextColor(
            typedArray.getColor(
                R.styleable.XdsChip_android_textColor, resources.getColor(R.color.white)
            )
        )
    }

    private fun setTextStyle() {
        textView.setTextAppearance(R.style.BodyMedium)
    }

    private fun setImage() {
        val iconDrawable = typedArray.getDrawable(R.styleable.XdsChip_iconImage)
        if (iconDrawable == null) {
            iconImageView.visibility = View.GONE
        } else {
            iconImageView.setImageDrawable(iconDrawable)
        }
    }

    private fun setBackground() {
        background = typedArray.getDrawable(R.styleable.XdsChip_android_background)
    }

    private fun setEnabled() {
        if (!typedArray.getBoolean(
                /* index = */ R.styleable.XdsChip_android_enabled,
                /* defValue = */ true,
            )
        ) {
            alpha = 0.4f
        }
    }

    private fun setDropDownImage() {
        val isDropDown = typedArray.getBoolean(
            /* index = */ R.styleable.XdsChip_isDropDown,
            /* defValue */ false,
        )
        val dropDownIcon = typedArray.getDrawable(R.styleable.XdsChip_dropDownIcon)
        if (!isDropDown) {
            dropDownImageView.visibility = View.GONE
        } else {
            dropDownImageView.setImageDrawable(dropDownIcon)
        }
    }
}
