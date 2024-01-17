package com.kotlincoders.nftexplorer.home.domain.model

data class CoinDetails(
    val availableSupply: Long,
    val icon: String,
    val id: String,
    val marketCap: Double,
    val name: String,
    val price: Double,
    val priceChange1d: Double,
    val priceChange1h: Double,
    val priceChange1w: Double,
    val redditUrl: String,
    val symbol: String,
    val totalSupply: Long,
    val twitterUrl: String,
    val volume: Double,
    val websiteUrl: String
)
