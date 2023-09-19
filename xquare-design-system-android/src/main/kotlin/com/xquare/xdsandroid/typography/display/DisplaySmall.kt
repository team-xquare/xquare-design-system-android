package com.xquare.xdsandroid.typography.display

import android.content.Context
import android.util.AttributeSet
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.typography.XdsTextView

@Deprecated(
    message = "Use 'style' attribute in layout",
    level = DeprecationLevel.HIDDEN,
)
public class DisplaySmall @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : XdsTextView(
    context = context,
    attrs = attrs,
    style = R.style.DisplaySmall,
)
