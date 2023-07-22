package com.xquare.xds

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import com.xquare.xquare_design_system_android.R

class HeadlineLarge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : AppCompatTextView(
    /* context = */ context,
    /* attrs = */ attrs,
) {

    private var typedArray: TypedArray

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.typography, findViewById(R.id.typography))
        typedArray = context.obtainStyledAttributes(
            /* set = */ attrs,
            /* attrs = */ R.styleable.HeadlineLarge,
        )
        setAttrs()
    }

    private fun setAttrs(){
        setTextStyle()
        setText()
        setTextColor()
    }

    private fun setTextStyle(){
        setTextAppearance(R.style.HeadlineLarge)
    }

    private fun setText(){
        text = typedArray.getText(R.styleable.HeadlineLarge_text)
    }

    private fun setTextColor(){
        setTextColor(typedArray.getColor(
            /* index = */ R.styleable.HeadlineLarge_textColor,
            /* defValue = */ resources.getColor(R.color.on_background),
        ))
    }
}