package com.kotlincoders.nftexplorer.home.presentation.coin_detail

import com.kotlincoders.nftexplorer.home.domain.model.CoinDetails


data class CoinDetailState (
    val coinDetails: CoinDetails? = null,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)