package com.xquare.xds.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.xquare.xquare_design_system_android.R

public class XButton @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(
    /* context = */ context,
    /* attrs = */ attrs,
) {

    private lateinit var typedArray: TypedArray

    private val textView: TextView by lazy {
        this.findViewById(R.id.tv_xbutton)
    }

    private val imageView: ImageView by lazy {
        this.findViewById(R.id.iv_xbutton)
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
            /* resource = */ R.layout.button,
            /* root = */ this,
        )
        typedArray = context.obtainStyledAttributes(
            /* set = */ attrs,
            /* attrs = */ R.styleable.XButton,
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
        textView.text = typedArray.getText(R.styleable.XButton_android_text)
    }

    private fun setTextStyle() {
        textView.setTextAppearance(R.style.BodyLarge)
    }

    private fun setTextColor(){
        textView.setTextColor(typedArray.getColor(R.styleable.XButton_textColor, resources.getColor(R.color.black)))
    }

    private fun setImage() {
        val drawable = typedArray.getDrawable(R.styleable.XButton_android_src)
        if (drawable == null) {
            imageView.visibility = View.GONE
        } else {
            imageView.setImageDrawable(drawable)
        }
    }

    private fun setBackground() {
        background = typedArray.getDrawable(R.styleable.XButton_android_background)
    }

    private fun setEnabled() {
        if (!typedArray.getBoolean(
                /* index = */ R.styleable.XButton_android_enabled,
                /* defValue = */ true,
            )
        ) {
            alpha = 0.4f
        }
    }
}
