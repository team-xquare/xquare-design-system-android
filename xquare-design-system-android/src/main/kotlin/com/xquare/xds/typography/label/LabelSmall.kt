package com.xquare.xds.typography.label

import android.content.Context
import android.util.AttributeSet
import com.xquare.xds.typography.XdsTextView
import com.xquare.xquare_design_system_android.R

class LabelSmall @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : XdsTextView(
    context = context,
    attrs = attrs,
    style = R.style.LabelSmall,
    color = R.color.neutral_50,
)
