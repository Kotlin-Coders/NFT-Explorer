package com.kotlincoders.nftexplorer.home.domain.repository

import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.model.Nft
import com.kotlincoders.nftexplorer.home.domain.model.NftDetails

interface HomeRepository {
    suspend fun getCoins(): Result<List<Coin>>

    suspend fun getTrendingNFTs(): Result<List<Nft>>

    suspend fun getNftDetails(nftAddress:String): Result<NftDetails>
}