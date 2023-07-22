package com.xquare.xds.typography.title

import android.content.Context
import android.util.AttributeSet
import com.xquare.xds.typography.Typography
import com.xquare.xquare_design_system_android.R

class TitleMedium @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : Typography(
    context = context,
    attrs = attrs,
    style = R.style.TitleMedium,
    color = R.color.neutral_10,
)
