package com.devx.moviehouse.ui.movieList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.devx.moviehouse.data.util.NetworkConstant
import com.devx.moviehouse.domain.model.MovieData

@Composable
internal fun BannerItem(media: MovieData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 250.dp)
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = "${NetworkConstant.IMAGE_BASE_URL}${media.posterPath}",
            contentDescription = media.posterPath,
            loading = {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(size = 150.dp)
                        .align(alignment = Alignment.Center)
                        .scale(scale = 0.5f)
                )
            },
            success = {
                Image(
                    painter = it.painter,
                    contentDescription = media.title,
                    contentScale = ContentScale.Crop,
                )
            },
            error = {
                Icon(
                    modifier = Modifier
                        .size(size = 100.dp)
                        .align(alignment = Alignment.Center),
                    imageVector = Icons.Rounded.ImageNotSupported,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = media.title
                )
            }
        )
    }
}

