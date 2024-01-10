package com.kotlincoders.nftexplorer.home.data.remote

import com.kotlincoders.nftexplorer.BuildConfig
import com.kotlincoders.nftexplorer.home.data.remote.dto.coin_detail.CoinDetailsDtoResponse
import com.kotlincoders.nftexplorer.home.data.remote.dto.coins.CoinsDtoResponse
import com.kotlincoders.nftexplorer.home.data.remote.dto.nft_collection_assets.NftCollectionAssetsDtoResponse
import com.kotlincoders.nftexplorer.home.data.remote.dto.nft_detail.NftDetailDtoResponse
import com.kotlincoders.nftexplorer.home.data.remote.dto.nfts.NftsDtoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface NftExplorerApi {
    companion object {
        const val BASE_URL = "https://openapiv1.coinstats.app/"
        const val API_KEY = BuildConfig.API_KEY
    }

    @GET("coins")
    suspend fun getCoins(
        @Header("accept") acceptHeader: String = "application/json",
        @Header("X-API-KEY") apiKey: String = API_KEY
    ): CoinsDtoResponse

    @GET("nft/trending")
    suspend fun getTrendingNFTs(
        @Header("accept") acceptHeader: String = "application/json",
        @Header("X-API-KEY") apiKey: String = API_KEY
    ): NftsDtoResponse

    @GET("nft/collection/{nft_address}")
    suspend fun getNftDetails(
        @Path("nft_address") nftAddress: String,
        @Header("accept") acceptHeader: String = "application/json",
        @Header("X-API-KEY") apiKey: String = API_KEY,
    ):NftDetailDtoResponse

    @GET("nft/{nft_address}/assets")
    suspend fun getNftCollectionAssets(
        @Path("nft_address") nftAddress: String,
        @Header("accept") acceptHeader: String = "application/json",
        @Header("X-API-KEY") apiKey: String = API_KEY,
    ):NftCollectionAssetsDtoResponse

    @GET("coins/{coinId}")
    suspend fun getCoinDetails(
        @Path("coinId") coinId: String,
        @Header("accept") acceptHeader: String = "application/json",
        @Header("X-API-KEY") apiKey: String = API_KEY,
    ):CoinDetailsDtoResponse

}