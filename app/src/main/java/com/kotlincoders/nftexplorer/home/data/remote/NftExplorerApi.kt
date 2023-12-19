package com.kotlincoders.nftexplorer.home.data.remote

import com.kotlincoders.nftexplorer.BuildConfig
import com.kotlincoders.nftexplorer.home.data.remote.dto.coins.CoinsDtoResponse
import com.kotlincoders.nftexplorer.home.data.remote.dto.nfts.NftsDtoResponse
import retrofit2.http.GET
import retrofit2.http.Header

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

}