package com.xquare.xds.typography.headline

import android.content.Context
import android.util.AttributeSet
import com.xquare.xds.typography.XdsTextView
import com.xquare.xquare_design_system_android.R

@Deprecated("Use 'style' attribute in layout")
public class HeadlineLarge @JvmOverloads public constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : XdsTextView(
    context = context,
    attrs = attrs,
    style = R.style.HeadlineLarge,
)
