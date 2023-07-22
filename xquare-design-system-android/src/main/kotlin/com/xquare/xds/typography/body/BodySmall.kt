package com.xquare.xds.typography.body

import android.content.Context
import android.util.AttributeSet
import com.xquare.xds.typography.Typography
import com.xquare.xquare_design_system_android.R

class BodySmall @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : Typography(
    context = context,
    attrs = attrs,
    style = R.style.BodySmall,
    color = R.color.neutral_30,
)
