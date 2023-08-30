package com.xquare.xdsandroid.checkbox

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.checkbox.MaterialCheckBox
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.util.setAlphaEnabled

public class XCheckBox(
    context: Context,
    attrs: AttributeSet?,
) : MaterialCheckBox(context, attrs),
    InitializableView,
    InitializableDrawable {

    override lateinit var attributes: TypedArray
    private var checkState: Int = 1

    init {
        initView(context, attrs, R.styleable.XCheckBox)
    }

    override fun setAttrs() {
        setDrawable()
        val isEnabled = attributes.getBoolean(R.styleable.XCheckBox_android_enabled, true)
        setAlphaEnabled(isEnabled)
    }

    override fun setDrawable() {
        setOnClickListener {
            when (checkState) {
                0 -> {
                    checkedState = STATE_UNCHECKED
                    checkState+=1
                }
                1 -> {
                    checkedState = STATE_CHECKED
                    checkState+=1
                }
                else -> {
                    checkedState = STATE_INDETERMINATE
                    checkState = 0
                }
            }
        }
    }
}