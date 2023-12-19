package com.kotlincoders.nftexplorer.home.presentation.home

import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.model.Nft

data class HomeState(
    val coins: List<Coin> = emptyList(),
    val nfts: List<Nft> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false
)