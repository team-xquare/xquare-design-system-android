package com.xquare.xdsandroid.chip

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

public class XIconChip(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatImageButton(context, attrs), InitializableView, InitializableDrawable {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XIconChip)
    }

    override fun setAttrs() {
        setDrawable()
        val isEnabled = attributes.getBoolean(R.styleable.XIconChip_android_enabled, true)
        setAlphaEnabled(isEnabled)
    }

    override fun setDrawable() {
        val src: Drawable? = getSrc()
        setImageDrawable(src)
    }

    private fun getSrc(): Drawable? {
        return attributes.getDrawable(R.styleable.XIconChip_android_src)?.apply {
            val srcWidth = attributes.getDimension(
                R.styleable.XIconChip_srcSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val srcHeight = attributes.getDimension(
                R.styleable.XIconChip_srcSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val srcTint = attributes.getColor(
                R.styleable.XIconChip_android_tint,
                androidx.appcompat.R.attr.tint,
            )

            this.setBounds(0, 0, srcWidth, srcHeight)
            DrawableCompat.wrap(drawable).setTint(srcTint)
        }
    }
}
