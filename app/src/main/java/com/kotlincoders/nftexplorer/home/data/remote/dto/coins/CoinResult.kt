package com.kotlincoders.nftexplorer.home.data.remote.dto.coins

data class CoinResult(
    val availableSupply: Long,
    val contractAddress: String,
    val decimals: Int,
    val explorers: List<String>,
    val icon: String,
    val id: String,
    val marketCap: Double,
    val name: String,
    val price: Double,
    val priceBtc: Double,
    val priceChange1d: Double,
    val priceChange1h: Double,
    val priceChange1w: Double,
    val rank: Int,
    val redditUrl: String,
    val symbol: String,
    val totalSupply: Long,
    val twitterUrl: String,
    val volume: Double,
    val websiteUrl: String
)