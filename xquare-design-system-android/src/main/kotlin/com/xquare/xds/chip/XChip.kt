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
) : LinearLayout(
    /* context = */ context,
    /* attrs = */ attr,
) {
    private lateinit var typedArray: TypedArray

    private val textView: TextView by lazy {
        this.findViewById(R.id.tv_xchip)
    }

    private val iconImageView: ImageView by lazy {
        this.findViewById(R.id.img_xchip_icon)
    }

    private val dropDownImageView: ImageView by lazy {
        this.findViewById(R.id.img_xchip_drop_down)
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
            /* attrs = */ R.styleable.XChip,
        )
    }

    private fun setAttrs() {
        setText()
        setIconImage()
        setBackground()
        setEnabled()
        setDropDownImage()
    }

    private fun setText() {
        val text = typedArray.getText(R.styleable.XChip_android_text)
        if (text == null) {
            textView.visibility = View.GONE
        } else {
            textView.text = text
        }
    }

    private fun setTextStyle() {
        textView.setTextAppearance(R.style.BodyMedium)
    }

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
    }

    private fun setBackground() {
        background = typedArray.getDrawable(R.styleable.XChip_android_background)
    }

    private fun setEnabled() {
        if (!typedArray.getBoolean(
                /* index = */ R.styleable.XChip_android_enabled,
                /* defValue = */ true,
            )
        ) {
            alpha = 0.4f
        }
    }

    private fun setDropDownImage() {
        val dropDownIcon = typedArray.getDrawable(R.styleable.XChip_dropDownIcon)
        if (dropDownIcon == null) {
            dropDownImageView.visibility = View.GONE
        } else {
            dropDownImageView.setImageDrawable(dropDownIcon)
        }
    }
}
