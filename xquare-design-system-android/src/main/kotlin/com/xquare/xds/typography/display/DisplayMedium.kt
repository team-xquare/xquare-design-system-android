package com.xquare.xds.typography.display

import android.content.Context
import android.util.AttributeSet
import com.xquare.xds.typography.XdsTextView
import com.xquare.xquare_design_system_android.R

class DisplayMedium @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : XdsTextView(
    context = context,
    attrs = attrs,
    style = R.style.DisplayMedium,
)
