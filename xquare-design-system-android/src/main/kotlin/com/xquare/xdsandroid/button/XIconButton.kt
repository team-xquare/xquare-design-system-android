package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.ViewDefaults

public class XIconButton(
    context: Context,
    attrs: AttributeSet?,
) : AppCompatImageButton(context, attrs), InitializableView {

    override lateinit var attributes: TypedArray

    init {
        initView(context, attrs, R.styleable.XIconButton)
    }

    override fun setAttrs() {
        setDrawableAttrs()
        setIsEnabled(
            attributes.getBoolean(
                R.styleable.XIconButton_android_enabled,
                true,
            ),
        )
    }

    override fun setDrawableAttrs() {
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

            DrawableCompat.wrap(this).setTint(srcTint)
            setImageDrawable(this)
        }
    }

    override fun setIsEnabled(enabled: Boolean) {
        if (!enabled) {
            alpha = ViewDefaults.VIEW_DISABLED
        }
        isEnabled = enabled
    }
}
