package com.devx.moviehouse.ui.movieList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devx.moviehouse.domain.model.MovieData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun AutoSwipeImagePager(mediaList: List<MovieData>) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        mediaList.size
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
            key = { mediaList[it].id },
        ) { index ->
            Box(modifier = Modifier.fillMaxWidth()) {
                BannerItem(media = mediaList[index])

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 12.dp,
                            top = 18.dp,
                        )
                        .align(alignment = Alignment.BottomStart)
                ) {
                    Text(
                        text = mediaList[index].title,
                        color = Color.White,
                    )
                }
            }

            LaunchedEffect(Unit) {
                while (true) {
                    delay(timeMillis = 3000.toLong())
                    scope.launch {
                        if (pagerState.canScrollForward) {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        } else {
                            pagerState.animateScrollToPage(page = 0)
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DotsIndicator(
                totalDots = mediaList.size,
                selectedIndex = pagerState.currentPage
            )
        }
    }
}
