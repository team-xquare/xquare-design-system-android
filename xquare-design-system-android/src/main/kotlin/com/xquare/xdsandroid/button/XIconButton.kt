package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.util.CustomViewUtil.setAlphaEnabled

public class XIconButton(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatImageButton(context, attrs),
    InitializableView,
    InitializableDrawable {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XIconButton)
    }

    override fun setAttrs() {
        setAlphaEnabled()
        setDrawable()
    }

    override fun setDrawable() {
        val drawable: Drawable? =
            attributes.getDrawable(R.styleable.XIconButton_android_src)?.apply {
                val srcWidth = attributes.getDimension(
                    R.styleable.XIconButton_srcSize,
                    this.intrinsicWidth.toFloat(),
                ).toInt()

                val srcHeight = attributes.getDimension(
                    R.styleable.XIconButton_srcSize,
                    this.intrinsicHeight.toFloat(),
                ).toInt()

                val srcTint = attributes.getColor(
                    R.styleable.XIconButton_android_tint,
                    androidx.appcompat.R.attr.tint,
                )

                setBounds(0, 0, srcWidth, srcHeight)
                DrawableCompat.wrap(drawable).setTint(srcTint)
            }
        setImageDrawable(drawable)
    }
}
