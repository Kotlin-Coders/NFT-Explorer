package com.kotlincoders.nftexplorer.home.domain.model

data class NftDetails (
    val address: String,
    val bannerImg: String,
    val img: String,
    val name: String,
    val creatorFee: Int,
    val totalSupply: Int,
    val floorPriceMc: Double,
    val totalVolume: Double,
)
