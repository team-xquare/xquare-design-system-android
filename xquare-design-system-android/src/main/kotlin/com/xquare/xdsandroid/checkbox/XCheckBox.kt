package com.xquare.xdsandroid.checkbox

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.util.setAlphaEnabled

public class XCheckBox(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatCheckBox(context, attrs),
    InitializableView,
    InitializableDrawable {

    override lateinit var attributes: TypedArray

    init {

    }

    override fun setAttrs() {
        setDrawable()
        setAlphaEnabled(isEnabled)
    }

    override fun setDrawable() {
        TODO("Not yet implemented")
    }
}