package com.xquare.xdsandroid.typography

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatTextView
import com.xquare.xdsandroid.R

@Deprecated(
    message = "Use 'style' attribute in layout",
    level = DeprecationLevel.WARNING,
)
public abstract class XdsTextView @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @StyleRes private val style: Int,
    @ColorRes private val color: Int = R.color.neutral_0,
) : AppCompatTextView(
    context,
    attrs,
) {

    private var typedArray: TypedArray

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(
            R.layout.typography,
            findViewById(R.id.typography),
        )
        typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.XdsTextView,
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
                R.styleable.XdsTextView_android_textColor,
                resources.getColor(color),
            ),
        )
    }

    private fun setIncludeFontPadding() {
        includeFontPadding = false
    }
}
