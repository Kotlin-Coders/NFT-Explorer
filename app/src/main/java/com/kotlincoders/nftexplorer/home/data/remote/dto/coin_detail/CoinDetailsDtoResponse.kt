package com.kotlincoders.nftexplorer.home.data.remote.dto.coin_detail

import com.kotlincoders.nftexplorer.home.domain.model.CoinDetails

data class CoinDetailsDtoResponse(
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

fun CoinDetailsDtoResponse.toCoinDetails(): CoinDetails {
    return CoinDetails(
        availableSupply,
        icon,
        id,
        marketCap,
        name,
        price,
        priceChange1d,
        priceChange1h,
        priceChange1w,
        redditUrl,
        symbol,
        totalSupply,
        twitterUrl,
        volume,
        websiteUrl
    )
}