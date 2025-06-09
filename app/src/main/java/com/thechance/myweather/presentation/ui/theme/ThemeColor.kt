package com.thechance.myweather.presentation.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

abstract class ThemeColor {
    abstract val backgroundMainColor: Color
    abstract val backgroundSecondaryColor: Color
    abstract val textColor: Color
    abstract val secondaryTextColor: Color
    abstract val blurColor: Color
    abstract val textBackgroundColor: Color
    val iconColor: Color = Companion.iconColor
    abstract val backgroundGradientColor: Brush

    companion object {
        private val iconColor = Color(0xFF87CEFA)
    }
}

object DayThemeColor : ThemeColor() {
    override val backgroundMainColor: Color
        get() = Color(0xFF87CEFA)
    override val backgroundSecondaryColor: Color
        get() = Color(0xFFFFFFFF)
    override val textColor: Color
        get() = Color(0xFF060414)
    override val secondaryTextColor: Color
        get() = Color(0xFF323232)
    override val blurColor: Color
        get() = Color(0xFF00619D)
    override val textBackgroundColor: Color
        get() = Color(0x06041414)
    override val backgroundGradientColor: Brush
        get() = Brush.verticalGradient(
            colors = listOf(backgroundMainColor, backgroundSecondaryColor)
        )
}

object NightThemeColor : ThemeColor() {
    override val backgroundMainColor: Color
        get() = Color(0xFF060414)
    override val backgroundSecondaryColor: Color
        get() = Color(0xFF0D0C19)
    override val textColor: Color
        get() = Color.White
    override val secondaryTextColor: Color
        get() = Color.White
    override val blurColor: Color
        get() = Color(0xFFC0B7FF)
    override val textBackgroundColor: Color
        get() = Color.White.copy(alpha = 0.08f)
    override val backgroundGradientColor: Brush
        get() = Brush.verticalGradient(
            colors = listOf(backgroundMainColor, backgroundSecondaryColor)
        )
}