package com.kotlincoders.nftexplorer.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerGray

@Composable
fun NftExplorerDataItem(
    firstTitle: String,
    secondTitle: String,
    firstData: String,
    secondData: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    firstTitle,
                    style = MaterialTheme.typography.titleSmall,
                    color = NftExplorerGray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    firstData,
                    style = MaterialTheme.typography.titleSmall,)
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
                    style = MaterialTheme.typography.titleSmall,
                    color = NftExplorerGray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    secondData,
                    style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}