package com.kotlincoders.nftexplorer.home.data.repository

import com.kotlincoders.nftexplorer.home.data.mapper.toDomain
import com.kotlincoders.nftexplorer.home.data.remote.NftExplorerApi
import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.model.Nft
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    val api : NftExplorerApi
) : HomeRepository {
    override suspend fun getCoins(): Result<List<Coin>> {
        return try{
            val coins = api.getCoins().result.map {it.toDomain()}
            Result.success(coins)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTrendingNFTs(): Result<List<Nft>> {
        return try{
            val nfts = api.getTrendingNFTs().data.map {it.toDomain()}
            Result.success(nfts)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

}