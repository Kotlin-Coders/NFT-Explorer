package com.kotlincoders.nftexplorer.home.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerCircularProgress
import com.kotlincoders.nftexplorer.home.domain.model.Nft
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NftItem(
    nft: Nft,
    onNftDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onNftDetail() },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = modifier
                    .size(100.dp)
                    .padding(end = 8.dp, top = 8.dp, start = 8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(NftExplorerBlack),
                contentAlignment = Alignment.Center
            ) {
                SubcomposeAsyncImage(
                    modifier = modifier.fillMaxSize(),
                    model = nft.img,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    loading = { NftExplorerCircularProgress() }
                )
            }
            Text(
                text = nft.name.uppercase(),
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center,
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier
                    .width(100.dp)
                    .padding(vertical = 8.dp, horizontal = 10.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }
}


