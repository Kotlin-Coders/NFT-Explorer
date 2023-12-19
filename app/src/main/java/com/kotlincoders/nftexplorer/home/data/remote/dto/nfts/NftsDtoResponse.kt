package com.kotlincoders.nftexplorer.home.data.remote.dto.nfts

data class NftsDtoResponse(
    val `data`: List<NftData>,
    val meta: Meta
)