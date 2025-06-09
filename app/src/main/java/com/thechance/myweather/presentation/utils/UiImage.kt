package com.thechance.myweather.presentation.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import java.io.File

sealed class UiImage {
    data class Drawable(@DrawableRes val id: Int) : UiImage()

    data class Url(val url: String) : UiImage()

    data class FileImage(val file: File) : UiImage()

    data class UriImage(val uri: Uri) : UiImage()

    data class BitmapImage(val bitmap: Bitmap) : UiImage()

    data class ComposeImageBitmap(val imageBitmap: ImageBitmap) : UiImage()

    @Composable
    fun asPainter(): Painter {
        return when (this) {
            is Drawable -> painterResource(id = resId)
            is Url -> rememberAsyncImagePainter(model = url)
            is FileImage -> rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(file)
                    .build()
            )
            is UriImage -> rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(uri)
                    .build()
            )
            is BitmapImage -> {
                BitmapPainter(bitmap.asImageBitmap())
            }
            is ComposeImageBitmap -> BitmapPainter(imageBitmap)
        }
    }

    @Composable
    fun Content(
        modifier: Modifier = Modifier,
        contentDescription: String? = null
    ) {
        when (this) {
            is Drawable, is Url, is FileImage, is UriImage, is BitmapImage, is ComposeImageBitmap -> {
                Image(
                    painter = asPainter(),
                    contentDescription = contentDescription,
                    modifier = modifier
                )
            }
        }
    }

    companion object {
        val Empty = Drawable(resId = R.color.transparent)
    }
}
