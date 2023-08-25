package com.xquare.xdsandroid.topappbar

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.common.Typable

public class XTopAppBar(
    context: Context,
    attrs: AttributeSet?,
) : LinearLayout(context, attrs),
    InitializableView,
    InitializableDrawable,
    Typable {

    override lateinit var attributes: TypedArray

    private val toolbarTopAppBar: Toolbar by lazy {
        findViewById(R.id.tool_bar_top_app_bar)
    }

    private val imageTopAppBar: ImageView by lazy {
        findViewById(R.id.image_top_app_bar)
    }

    private val tvTopAppBar: TextView by lazy {
        findViewById(R.id.tv_top_app_bar)
    }

    init {
        initView(context, attrs, R.styleable.XTopAppBar)
    }

    override fun setAttrs() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.top_app_bar, this, true)

        val menu = attributes.getResourceId(
            R.styleable.XTopAppBar_menu,
            R.menu.menu_top_app_bar_default,
        )
        toolbarTopAppBar.inflateMenu(menu)

        setTextAttrs(attributes.getText(R.styleable.XTopAppBar_android_text))
        setDrawable()
    }

    override fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean,
        includeFontPadding: Boolean,
    ) {
        val textAppearance = attributes.getResourceId(
            R.styleable.XTopAppBar_android_textAppearance,
            R.style.TitleMedium,
        )

        val textStyle = ResourcesCompat.getFont(
            context,
            attributes.getResourceId(
                R.styleable.XButton_android_textStyle,
                R.font.notosans_medium,
            ),
        )

        val textColor = attributes.getColor(
            R.styleable.XTopAppBar_android_textColor,
            androidx.appcompat.R.attr.colorPrimary,
        )

        with(tvTopAppBar) {
            this.text = text

            typeface = textStyle
            setTextAppearance(textAppearance)
            setTextColor(textColor)

            this.isAllCaps = isAllCaps
            this.includeFontPadding = includeFontPadding
        }
    }

    override fun setDrawable() {
        val navigationIcon: Drawable? = getNavigationIcon()
        imageTopAppBar.setImageDrawable(navigationIcon)
    }

    private fun getNavigationIcon(): Drawable? {
        return attributes.getDrawable(R.styleable.XTopAppBar_android_navigationIcon)?.apply {
            val width = attributes.getDimension(
                R.styleable.XTopAppBar_navigationIconSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.XTopAppBar_navigationIconSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.XTopAppBar_navigationIconTint,
                R.attr.leadingSrcTint,
            )

            imageTopAppBar.layoutParams.width = width
            imageTopAppBar.layoutParams.height = height

            setBounds(0, 0, width, height)

            DrawableCompat.wrap(this@apply).setTint(tint)
        }
    }
}
