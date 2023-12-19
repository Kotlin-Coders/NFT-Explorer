package com.kotlincoders.nftexplorer.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotlincoders.nftexplorer.R
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerCircularProgress
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerConnectionError
import com.kotlincoders.nftexplorer.home.presentation.home.components.CoinItem
import com.kotlincoders.nftexplorer.home.presentation.home.components.NftItem
import com.kotlincoders.nftexplorer.core.presentation.NftExplorerVerticalGrid

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onCoinDetail: () -> Unit,
    onNftDetail: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (state.isError) {
            NftExplorerConnectionError(onRetry = { viewModel.getAllCoinsAndNfts() })
        } else if (state.coins.isNotEmpty() && state.nfts.isNotEmpty()) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                stringResource(R.string.app_name),
                                style = MaterialTheme.typography.titleLarge
                            )
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                    )
                }
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    LazyColumn() {
                        item {
                            Text(
                                text = stringResource(R.string.trending_nfts),
                                modifier = Modifier.padding(start = 16.dp),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        item {
                            LazyRow(contentPadding = PaddingValues(8.dp)) {
                                items(state.nfts) {
                                    NftItem(it, { onNftDetail() })
                                }
                            }
                        }
                        item {
                            Text(
                                text = stringResource(R.string.ranking_coins),
                                modifier = Modifier.padding(start = 16.dp),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        item {
                            NftExplorerVerticalGrid(
                                modifier = Modifier.fillMaxWidth(),
                                items = state.coins.map {
                                    { CoinItem(it, { onCoinDetail() }) }
                                }
                            )
                        }
                    }
                }
            }
        } else if (state.isLoading) {
            NftExplorerCircularProgress()
        }
    }
}