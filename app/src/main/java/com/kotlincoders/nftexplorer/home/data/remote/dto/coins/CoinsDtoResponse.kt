package com.kotlincoders.nftexplorer.home.data.remote.dto.coins

data class CoinsDtoResponse(
    val meta: Meta,
    val result: List<CoinResult>
)