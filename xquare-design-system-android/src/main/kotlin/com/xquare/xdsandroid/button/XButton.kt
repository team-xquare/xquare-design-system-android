package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.xquare.xdsandroid.R

public class XButton @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : AppCompatButton(
    context,
    attrs,
) {

    private lateinit var typedArray: TypedArray

    private val tvButton: TextView by lazy {
        this.findViewById(R.id.tv_button)
    }

    private val imageButton: ImageView by lazy {
        this.findViewById(R.id.image_button)
    }

    init {
        initView(
            context = context,
            attrs = attrs,
        )
        setAttrs()
    }

    private fun initView(
        context: Context,
        attrs: AttributeSet? = null,
    ) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(
            R.layout.button,
            findViewById(R.id.cl_button),
        )
        typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.XButton,
        )
    }

    private fun setAttrs() {
        setText()
        setTextStyle()
        setTextColor()
        setImage()
        setBackground()
        setEnabled()
    }

    private fun setText() {
        val text = typedArray.getText(R.styleable.XButton_android_text)
        if (text == null) {
            tvButton.visibility = View.GONE
        } else {
            tvButton.text = text
        }
    }

    private fun setTextStyle() {
        tvButton.setTextAppearance(R.style.BodyLarge)
    }

    private fun setTextColor() {
        tvButton.setTextColor(
            typedArray.getColor(
                R.styleable.XButton_android_textColor,
                resources.getColor(R.color.black),
            ),
        )
    }

    private fun setImage() {
        val drawable = typedArray.getDrawable(R.styleable.XButton_android_drawable)
        if (drawable == null) {
            imageButton.visibility = View.GONE
        } else {
            imageButton.setImageDrawable(drawable)
        }
    }

    private fun setBackground() {
        background = typedArray.getDrawable(R.styleable.XButton_android_background)
    }

    private fun setEnabled() {
        if (!typedArray.getBoolean(
                R.styleable.XButton_android_enabled,
                true,
            )
        ) {
            alpha = 0.4f
        }
    }
}
