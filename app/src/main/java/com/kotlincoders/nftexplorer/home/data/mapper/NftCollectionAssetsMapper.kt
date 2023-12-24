package com.kotlincoders.nftexplorer.home.data.mapper

import com.kotlincoders.nftexplorer.home.data.remote.dto.nft_collection_assets.Data
import com.kotlincoders.nftexplorer.home.domain.model.NftCollectionAssets

fun Data.toDomain():NftCollectionAssets{
    return NftCollectionAssets(
       name, previewUrl
    )
}