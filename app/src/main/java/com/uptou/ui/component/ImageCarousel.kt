package com.uptou.ui.component

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.uptou.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel() {
    val listImages = listOf(
        "https://picsum.photos/id/237/1600/1000",
        "https://picsum.photos/id/238/1600/1000",
        "https://picsum.photos/id/239/1600/1000",
        "https://picsum.photos/id/240/1600/1000",
        "https://picsum.photos/id/241/1600/1000",
        "https://picsum.photos/id/242/1600/1000",
    )
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        HorizontalPager(
            contentPadding = PaddingValues(20.dp),
            state = pagerState,
            pageCount = listImages.size,
            pageSpacing = 20.dp
        ){page ->
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(listImages[page])
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.error_image),
                    error = painterResource(id = R.drawable.error_image),
                )
            }
        }
        Row(
            Modifier
                .height(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(listImages.size) { index ->
                val color = if (pagerState.currentPage == index) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                        .clickable {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                )
            }
        }
        LaunchedEffect(pagerState.currentPage){
            delay(1000) // wait for 3 seconds.
            // increasing the position and check the limit
            var newPosition = pagerState.currentPage + 1
            if (newPosition > listImages.lastIndex) newPosition = 0
            // scrolling to the new position.
            pagerState.animateScrollToPage(newPosition)
        }
    }
}