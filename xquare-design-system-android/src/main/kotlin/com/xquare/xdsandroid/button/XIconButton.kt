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
import com.xquare.xdsandroid.util.setAlphaEnabled

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
        setDrawable()
        val isEnabled = attributes.getBoolean(R.styleable.XIconButton_android_enabled, true)
        setAlphaEnabled(isEnabled)
    }

    override fun setDrawable() {
        val src: Drawable? = getSrc()
        setImageDrawable(src)
    }

    private fun getSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XIconButton_android_src)?.apply {
            val width = attributes.getDimension(
                R.styleable.XIconButton_srcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.XIconButton_srcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.XIconButton_android_tint,
                androidx.appcompat.R.attr.tint,
            )

            this.setBounds(0, 0, width, height)

            DrawableCompat.wrap(this@apply).setTint(tint)
        }
    }
}
