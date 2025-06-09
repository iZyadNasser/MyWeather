package com.thechance.myweather.presentation.utils

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

sealed class UiImage {
    data class Drawable(@DrawableRes val id: Int) : UiImage()

    @Composable
    fun asPainter(): Painter {
        return when (this) {
            is Drawable -> painterResource(id = this.id)
        }
    }

    @DrawableRes fun asResource(): Int {
        return when (this) {
            is Drawable -> this.id
        }
    }
}
