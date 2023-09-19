package com.xquare.xdsandroid.common

internal interface Typable {
    fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean = false,
        includeFontPadding: Boolean = false,
    )
}
