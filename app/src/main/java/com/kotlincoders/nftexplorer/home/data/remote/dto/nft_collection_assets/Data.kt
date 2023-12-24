package com.kotlincoders.nftexplorer.home.data.remote.dto.nft_collection_assets

data class Data(
    val address: String?,
    val attributes: List<Attribute>?,
    val blockchain: String?,
    val collectionId: String?,
    val lastSaleDate: String?,
    val lastSalePrice: Double?,
    val name: String?,
    val previewUrl: String?,
    val rarityRank: Int?,
    val rarityScore: Double?,
    val source: String?,
    val standard: String?,
    val tokenId: String?,
    val url: String?
)