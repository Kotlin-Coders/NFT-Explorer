package com.kotlincoders.nftexplorer.home.presentation.home.components

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.kotlincoders.nftexplorer.R
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerCircularProgress
import com.kotlincoders.nftexplorer.home.domain.model.Coin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinItem(
    coin:Coin,
    onCoinDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onCoinDetail() },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                modifier = modifier.size(64.dp),
                model = coin.icon,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                loading = { NftExplorerCircularProgress() }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.rank) + coin.rank,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = coin.name.uppercase(),
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}