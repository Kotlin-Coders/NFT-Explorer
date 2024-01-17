package com.kotlincoders.nftexplorer.home.data.repository

import com.kotlincoders.nftexplorer.home.data.mapper.toDomain
import com.kotlincoders.nftexplorer.home.data.remote.NftExplorerApi
import com.kotlincoders.nftexplorer.home.data.remote.dto.coin_detail.toCoinDetails
import com.kotlincoders.nftexplorer.home.data.remote.dto.nft_detail.toNftDetail
import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.model.CoinDetails
import com.kotlincoders.nftexplorer.home.domain.model.Nft
import com.kotlincoders.nftexplorer.home.domain.model.NftCollectionAssets
import com.kotlincoders.nftexplorer.home.domain.model.NftDetails
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val api : NftExplorerApi
) : HomeRepository {
    override suspend fun getCoins(): Result<List<Coin>> {
        return try{
            val coins = api.getCoins().result.map {it.toDomain()}
            Result.success(coins)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCoinDetails(coinId: String): Result<CoinDetails> {
        return try{
            val coinDetails = api.getCoinDetails(coinId).toCoinDetails()
            Result.success(coinDetails)
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

    override suspend fun getNftDetails(nftAddress: String): Result<NftDetails> {
        return try{
            val response = api.getNftDetails(nftAddress).toNftDetail()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getNftCollectionAssets(nftAddress: String): Result<List<NftCollectionAssets>> {
        return try {
            val assets = api.getNftCollectionAssets(nftAddress).data.map { it.toDomain() }
            Result.success(assets)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }


}