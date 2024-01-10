package com.kotlincoders.nftexplorer.home.presentation.coin_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kotlincoders.nftexplorer.R
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerCircularProgress
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerConnectionError
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerDataItem
import com.kotlincoders.nftexplorer.home.presentation.coin_detail.components.CoinPriceChangeItem
import com.kotlincoders.nftexplorer.home.presentation.coin_detail.components.CoinSocialLinksItem
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerOrange
import com.kotlincoders.nftexplorer.ui.theme.NftExplorerPink
import java.text.DecimalFormat

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (state.isError) {
            NftExplorerConnectionError(onRetry = { viewModel.getCoinDetails() })
        } else if (state.coinDetails != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(Modifier.fillMaxSize()) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(170.dp)
                                    .clip(
                                        shape = RoundedCornerShape(
                                            topStart = 0.dp,
                                            topEnd = 0.dp,
                                            bottomEnd = 20.dp,
                                            bottomStart = 20.dp
                                        )
                                    )
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(NftExplorerPink, NftExplorerOrange)
                                        )
                                    )
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 120.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    model = state.coinDetails.icon,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                        .clip(
                                            shape = RoundedCornerShape(20.dp)
                                        ),
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    text = state.coinDetails.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = state.coinDetails.symbol,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                    item {
                        Text(
                            text = stringResource(R.string.price),
                            modifier = Modifier.padding(start = 16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    item {
                        val priceFormatted =
                            DecimalFormat("#.##").format(state.coinDetails.price) + "$"
                        Text(
                            text = priceFormatted,
                            modifier = Modifier.padding(start = 16.dp),
                            style = MaterialTheme.typography.titleMedium,
                            color = NftExplorerPink
                        )
                    }
                    item {
                        CoinPriceChangeItem(
                            firstTitle = stringResource(R.string.one_hour),
                            secondTitle = stringResource(R.string.one_day),
                            thirdTitle = stringResource(R.string.one_week),
                            firstData = state.coinDetails.priceChange1h.toString(),
                            secondData = state.coinDetails.priceChange1d.toString(),
                            thirdData = state.coinDetails.priceChange1w.toString()
                        )
                    }
                    item {
                        Box(modifier = Modifier.padding(16.dp)) {
                            NftExplorerDataItem(
                                firstTitle = stringResource(R.string.total_supply),
                                secondTitle = stringResource(R.string.available_supply),
                                firstData = state.coinDetails.totalSupply.toString(),
                                secondData = state.coinDetails.availableSupply.toString()
                            )
                        }
                    }
                    //chart

                    item {
                        Text(
                            text = stringResource(R.string.social),
                            modifier = Modifier.padding(start = 16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    item {
                        CoinSocialLinksItem(
                            redditUrl = state.coinDetails.redditUrl,
                            twitterUrl = state.coinDetails.twitterUrl,
                            websiteUrl = state.coinDetails.websiteUrl
                        )
                    }

                }
            }
        } else if (state.isLoading) {
            NftExplorerCircularProgress()
        }
    }
}