package com.xquare.xds.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.xquare.xquare_design_system_android.R

public class XFloatingActionButton @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(
    /* context = */ context,
    /* attrs = */ attrs,
) {

    private lateinit var typedArray: TypedArray

    private val imageView: ImageView by lazy {
        this.findViewById(R.id.iv_xbutton_floating)
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
            /* resource = */ R.layout.button_floating,
            /* root = */ this,
        )
        typedArray = context.obtainStyledAttributes(
            /* set = */ attrs,
            /* attrs = */ R.styleable.XFloatingActionButton,
        )
    }

    private fun setAttrs() {
        setImage()
        setEnabled()
        setElevation()
    }

    private fun setImage() {
        val drawable = typedArray.getDrawable(R.styleable.XFloatingActionButton_android_src)
        if (drawable == null) {
            imageView.visibility = View.GONE
        } else imageView.setImageDrawable(drawable)

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

    private fun setElevation(){
        //elevation = typedArray.getFloat(R.styleable.XFloatingActionButton_android_elevation, 0f)
    }
}
