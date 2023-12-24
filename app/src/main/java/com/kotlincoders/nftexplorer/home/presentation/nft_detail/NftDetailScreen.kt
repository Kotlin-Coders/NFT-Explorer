package com.kotlincoders.nftexplorer.home.presentation.nft_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kotlincoders.nftexplorer.R
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerCircularProgress
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerConnectionError
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerDataItem
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerVerticalGrid
import com.kotlincoders.nftexplorer.home.presentation.home.components.CoinItem
import com.kotlincoders.nftexplorer.home.presentation.nft_detail.components.NftAssetsItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NftDetailScreen(
    viewModel: NftDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (state.isError) {
            NftExplorerConnectionError(onRetry = { viewModel.getNftDetails() })
        } else if ((state.nftDetails != null) && state.nftCollectionAssets.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(Modifier.fillMaxSize()) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            AsyncImage(
                                model = state.nftDetails.bannerImg,
                                contentDescription = null,
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
                                    ),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 120.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    model = state.nftDetails.img,
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
                                    text = state.nftDetails.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                    item {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Spacer(modifier = Modifier.height(16.dp))
                            NftExplorerDataItem(
                                firstTitle = stringResource(R.string.creator_fee),
                                firstData = state.nftDetails.creatorFee.toString() + "%",
                                secondTitle = stringResource(R.string.total_supply),
                                secondData = state.nftDetails.totalSupply.toString()
                            )
                            Spacer(modifier = Modifier.height(28.dp))
                            NftExplorerDataItem(
                                firstTitle = stringResource(R.string.floor_price),
                                firstData = "${state.nftDetails.floorPriceMc.toString()} ${state.nftDetails.blockchain.toString()}",
                                secondTitle = stringResource(R.string.volumen),
                                secondData = state.nftDetails.volume.toString()
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                stringResource(R.string.collection),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                    item {
                        NftExplorerVerticalGrid(
                            modifier = Modifier.fillMaxWidth(),
                            items = state.nftCollectionAssets.map {
                                { NftAssetsItem(it) }
                            }
                        )
                    }

                }
            }
        } else if (state.isLoading) {
            NftExplorerCircularProgress()
        }
    }
}