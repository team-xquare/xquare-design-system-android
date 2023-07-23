package com.xquare.xds.typography

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatTextView
import com.xquare.xquare_design_system_android.R

public abstract class XdsTextView @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @StyleRes private val style: Int,
    @ColorRes private val color: Int = R.color.neutral_0,
) : AppCompatTextView(
    /* context = */ context,
    /* attrs = */ attrs,
) {

    private var typedArray: TypedArray

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(
            /* resource = */ R.layout.typography,
            /* root = */ findViewById(R.id.typography),
        )
        typedArray = context.obtainStyledAttributes(
            /* set = */ attrs,
            /* attrs = */ R.styleable.XdsTextView,
        )
        setAttrs()
    }

    private fun setAttrs() {
        setTextStyle()
        setText()
        setTextColor()
        setIncludeFontPadding()
    }

    private fun setTextStyle() {
        setTextAppearance(style)
    }

    private fun setText() {
        text = typedArray.getText(R.styleable.XdsTextView_android_text)
    }

    private fun setTextColor() {
        setTextColor(
            typedArray.getColor(
                /* index = */ R.styleable.XdsTextView_android_textColor,
                /* defValue = */ resources.getColor(color),
            ),
        )
    }

    private fun setIncludeFontPadding() {
        includeFontPadding = false
    }
}
