package com.xquare.xdsandroid.typography.label

import android.content.Context
import android.util.AttributeSet
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.typography.XdsTextView

@Deprecated(
    message = "Use 'style' attribute in layout",
    level = DeprecationLevel.HIDDEN,
)
public class LabelLarge @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : XdsTextView(
    context = context,
    attrs = attrs,
    style = R.style.LabelLarge,
    color = R.color.neutral_50,
)
