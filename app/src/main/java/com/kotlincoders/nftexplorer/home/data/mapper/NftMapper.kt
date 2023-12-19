package com.kotlincoders.nftexplorer.home.data.mapper

import com.kotlincoders.nftexplorer.home.data.remote.dto.nfts.NftData
import com.kotlincoders.nftexplorer.home.domain.model.Nft

fun NftData.toDomain(): Nft {
    return Nft(
        address, img, name
    )
}