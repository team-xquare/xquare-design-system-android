package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.ViewDefaults

public class XIconButton : AppCompatImageButton, InitializableView {

    public constructor(context: Context) : this(
        context = context,
        attrs = null,
    )

    public constructor(
        context: Context,
        attrs: AttributeSet?,
    ) : super(context, attrs) {
        initView(
            context = context,
            attrs = attrs,
        )
    }

    private lateinit var attributes: TypedArray

    override fun initView(
        context: Context,
        attrs: AttributeSet?,
    ) {
        attributes = context.obtainStyledAttributes(attrs, R.styleable.XIconButton)
        setAttrs()
        attributes.recycle()
    }

    override fun setAttrs() {
        setDrawableAttrs()
    }

    override fun setDrawableAttrs() {
        attributes.getDrawable(R.styleable.XIconButton_android_src)?.apply {
            DrawableCompat.wrap(this).setTint(
                attributes.getColor(
                    R.styleable.XIconButton_android_tint,
                    R.styleable.XIconButton_android_tint,
                ),
            )
            setImageDrawable(this)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(
            attributes.getBoolean(
                R.styleable.XButton_android_enabled,
                true,
            ),
        )

        if (!enabled) {
            alpha = ViewDefaults.VIEW_DISABLED
        }
        isEnabled = enabled
    }
}
