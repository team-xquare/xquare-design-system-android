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
import androidx.core.view.get
import com.xquare.xdsandroid.R
import com.xquare.xdsandroid.common.InitializableDrawable
import com.xquare.xdsandroid.common.InitializableView
import com.xquare.xdsandroid.common.Typable
import com.xquare.xdsandroid.util.setAlphaEnabled

public class CollapsedXTopAppBar(
    context: Context,
    attrs: AttributeSet?,
) : LinearLayout(context, attrs),
    InitializableView,
    InitializableDrawable,
    Typable {

    override lateinit var attributes: TypedArray

    private val toolbarTopAppBarCollapsed: Toolbar by lazy {
        findViewById(R.id.tool_bar_top_app_bar_collapsed)
    }

    private val imageTopAppBarCollapsed: ImageView by lazy {
        findViewById(R.id.image_top_app_bar_collapsed)
    }

    private val tvTopAppBarCollapsed: TextView by lazy {
        findViewById(R.id.tv_top_app_bar_collapsed)
    }

    private val menuImageViews: List<ImageView> by lazy {
        listOf(
            findViewById(R.id.image_top_app_bar_collapsed_menu_first),
            findViewById(R.id.image_top_app_bar_collapsed_menu_second),
            findViewById(R.id.image_top_app_bar_collapsed_menu_third),
        )
    }

    init {
        initView(context, attrs, R.styleable.CollapsedXTopAppBar)
    }

    override fun setAttrs() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.top_app_bar_collapsed, this, true)

        val isEnabled = attributes.getBoolean(R.styleable.CollapsedXTopAppBar_android_enabled, true)
        setAlphaEnabled(isEnabled)

        setTextAttrs(attributes.getText(R.styleable.CollapsedXTopAppBar_android_text))
        setDrawable()

        val backgroundColor = attributes.getColor(
            R.styleable.CollapsedXTopAppBar_backgroundColor,
            com.google.android.material.R.attr.colorSurface,
        )
        setBackgroundColor(backgroundColor)
    }

    override fun setTextAttrs(
        text: CharSequence,
        isAllCaps: Boolean,
        includeFontPadding: Boolean,
    ) {
        val textAppearance = attributes.getResourceId(
            R.styleable.CollapsedXTopAppBar_android_textAppearance,
            R.style.TitleMedium,
        )

        val textStyle = ResourcesCompat.getFont(
            context,
            attributes.getResourceId(
                R.styleable.CollapsedXTopAppBar_android_textStyle,
                R.font.notosans_medium,
            ),
        )

        val textColor = attributes.getColor(
            R.styleable.CollapsedXTopAppBar_android_textColor,
            androidx.appcompat.R.attr.colorPrimary,
        )

        with(tvTopAppBarCollapsed) {
            this.text = text

            typeface = textStyle
            this.setTextAppearance(textAppearance)
            setTextColor(textColor)

            this.isAllCaps = isAllCaps
            this.includeFontPadding = includeFontPadding
        }
    }

    override fun setDrawable() {
        val navigationIcon: Drawable? = getNavigationIcon()
        imageTopAppBarCollapsed.setImageDrawable(navigationIcon)

        val menuResourceId = attributes.getResourceId(
            R.styleable.CollapsedXTopAppBar_menu,
            R.menu.menu_top_app_bar_default,
        )

        toolbarTopAppBarCollapsed.inflateMenu(menuResourceId)

        val menuIcons = toolbarTopAppBarCollapsed.menu

        repeat(menuIcons.size()) {
            menuImageViews[it].setImageDrawable(setMenuIconAttrs(menuIcons[it].icon))
        }

        menuIcons.clear()
    }

    private fun setMenuIconAttrs(menuIcon: Drawable?): Drawable? {
        return menuIcon?.apply {
            val width = attributes.getDimension(
                R.styleable.CollapsedXTopAppBar_menuIconSize,
                this.intrinsicWidth.toFloat(),
            ).toInt()

            val height = attributes.getDimension(
                R.styleable.CollapsedXTopAppBar_menuIconSize,
                this.intrinsicHeight.toFloat(),
            ).toInt()

            val tint = attributes.getColor(
                R.styleable.CollapsedXTopAppBar_menuIconTint,
                R.attr.menuIconTint,
            )

            this.setBounds(0, 0, width, height)

            DrawableCompat.wrap(this).setTint(tint)
        }
    }

    private fun getNavigationIcon(): Drawable? {
        return attributes.getDrawable(R.styleable.CollapsedXTopAppBar_android_navigationIcon)
            ?.apply {
                val width = attributes.getDimension(
                    R.styleable.CollapsedXTopAppBar_navigationIconSize,
                    this.intrinsicWidth.toFloat(),
                ).toInt()

                val height = attributes.getDimension(
                    R.styleable.CollapsedXTopAppBar_navigationIconSize,
                    this.intrinsicHeight.toFloat(),
                ).toInt()

                val tint = attributes.getColor(
                    R.styleable.CollapsedXTopAppBar_navigationIconTint,
                    R.attr.leadingSrcTint,
                )

                imageTopAppBarCollapsed.layoutParams.width = width
                imageTopAppBarCollapsed.layoutParams.height = height

                setBounds(0, 0, width, height)

                DrawableCompat.wrap(this@apply).setTint(tint)
            }
    }
}
