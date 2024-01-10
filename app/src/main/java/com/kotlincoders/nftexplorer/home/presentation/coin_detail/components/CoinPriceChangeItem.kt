package com.kotlincoders.nftexplorer.home.presentation.coin_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerGray
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerGreen
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerRed

@Composable
fun CoinPriceChangeItem(
    firstTitle: String,
    secondTitle: String,
    thirdTitle: String,
    firstData: String,
    secondData: String,
    thirdData: String,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    val textStyle = MaterialTheme.typography.titleSmall

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(110.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            fun getTextColor(data: String): Color {
                return if ((data.toDoubleOrNull() ?: 0.0) >= 0) {
                    NftExplorerGreen
                } else {
                    NftExplorerRed
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    firstTitle,
                    style = textStyle,
                    color = NftExplorerGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    "$firstData%",
                    style = textStyle,
                    color = getTextColor(firstData)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    secondTitle,
                    style = textStyle,
                    color = NftExplorerGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    "$secondData%",
                    style = textStyle,
                    color = getTextColor(secondData)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    thirdTitle,
                    style = textStyle,
                    color = NftExplorerGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    "$thirdData%",
                    style = textStyle,
                    color = getTextColor(thirdData)
                )
            }
        }
    }
}
