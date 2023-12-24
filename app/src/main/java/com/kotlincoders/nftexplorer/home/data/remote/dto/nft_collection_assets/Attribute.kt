package com.kotlincoders.nftexplorer.home.data.remote.dto.nft_collection_assets

data class Attribute(
    val createdAt: String?,
    val floorAskPrice: Double?,
    val key: String?,
    val kind: String?,
    val onSaleCount: Int?,
    val tokenCount: Int?,
    val topBidValue: Double?,
    val value: String?
)