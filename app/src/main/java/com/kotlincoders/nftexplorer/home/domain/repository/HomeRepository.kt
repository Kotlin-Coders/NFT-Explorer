package com.kotlincoders.nftexplorer.home.domain.repository

import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.model.Nft

interface HomeRepository {
    suspend fun getCoins(): Result<List<Coin>>

    suspend fun getTrendingNFTs(): Result<List<Nft>>
}