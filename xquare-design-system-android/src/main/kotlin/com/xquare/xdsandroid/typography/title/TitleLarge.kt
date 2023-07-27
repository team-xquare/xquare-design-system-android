package com.xquare.xdsandroid.typography.title

import android.content.Context
import android.util.AttributeSet
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.typography.XdsTextView

@Deprecated(
    message = "Use 'style' attribute in layout",
    level = DeprecationLevel.HIDDEN,
)
public class TitleLarge @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : XdsTextView(
    context = context,
    attrs = attrs,
    style = R.style.TitleLarge,
    color = R.color.neutral_10,
)
