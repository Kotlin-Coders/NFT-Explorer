package com.kotlincoders.nftexplorer.home.presentation.nft_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.kotlincoders.nftexplorer.R
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerCircularProgress
import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.model.NftCollectionAssets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NftAssetsItem(
    nftCollectionAssets: NftCollectionAssets,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(20.dp)
                    ),
                model = nftCollectionAssets.previewUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                loading = { NftExplorerCircularProgress() }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = nftCollectionAssets.name?:"",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}