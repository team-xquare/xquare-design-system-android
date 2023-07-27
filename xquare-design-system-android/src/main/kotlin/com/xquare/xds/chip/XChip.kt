package com.xquare.xds.chip

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import com.xquare.xquare_design_system_android.R

public class XChip @JvmOverloads public constructor(
    context: Context,
    attr: AttributeSet? = null,
) : LinearLayout(context, attr) {
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
        context: Context? = null,
        attrs: AttributeSet? = null,
    ) {
        val inflater =
            context?.applicationContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.chip, this)
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.XChip)
    }

    private fun setAttrs() {
        setText()
        setTextStyle()
        setTextColor()
        setIconImage()
        setDropDownImage()
        setEnabled()
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
                context.resources.getColor(R.color.on_primary),
            )
        )
    }

    private fun setIconImage() {
        val iconDrawable = typedArray.getDrawable(R.styleable.XChip_leadingIcon)
        if (iconDrawable == null) {
            iconImageView.visibility = View.GONE
        } else {
            iconImageView.setImageDrawable(iconDrawable)
        }
    }

    private fun setEnabled() {
        if (!typedArray.getBoolean(R.styleable.XChip_android_enabled, true)) {
            alpha = 0.4f
        }
    }

    private fun setDropDownImage() {
        val dropDownIcon = typedArray.getDrawable(R.styleable.XChip_trailingIcon)
        if (dropDownIcon == null) {
            dropDownImageView.visibility = View.GONE
        } else {
            dropDownImageView.setImageDrawable(dropDownIcon)
        }
    }
}
