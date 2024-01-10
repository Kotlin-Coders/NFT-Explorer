package com.kotlincoders.nftexplorer.home.presentation.coin_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kotlincoders.nftexplorer.R

@Composable
fun CoinSocialLinksItem(
    redditUrl: String,
    twitterUrl: String,
    websiteUrl: String
) {

    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(16.dp)
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_twitter),
                contentDescription = "",
                Modifier.clickable {
                    uriHandler.openUri(twitterUrl)
                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_website),
                contentDescription = "",
                Modifier.clickable {
                    uriHandler.openUri(websiteUrl)
                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_reddit),
                contentDescription = "",
                Modifier.clickable {
                    uriHandler.openUri(redditUrl)
                }
            )
        }
    }
}