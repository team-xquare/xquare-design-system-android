package com.xquare.xdsandroid.button

internal interface Typable {
    fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean = false,
        includeFontPadding: Boolean = false,
    )
}
