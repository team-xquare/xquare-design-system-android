package com.xquare.xdsandroid.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import com.xquare.xdsandroid.ButtonConstants
import com.xquare.xdsandroid.R

public class XIconButton : AppCompatImageButton, ButtonSrc, ButtonBase {

    public constructor(context: Context) : this(context, null)

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

    private var src: Drawable? = null

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
        setIsEnabled()
    }

    override fun setDrawableAttrs() {
        src = attributes.getDrawable(R.styleable.XIconButton_android_src)
        setImageDrawable(src)
    }

    override fun setIsEnabled() {
        val buttonEnabled = attributes.getBoolean(R.styleable.XIconButton_android_enabled, true)

        if (!buttonEnabled) {
            alpha = ButtonConstants.BUTTON_DISABLED
        }

        isEnabled = buttonEnabled
    }
}
