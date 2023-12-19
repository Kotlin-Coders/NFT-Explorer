package com.kotlincoders.nftexplorer.home.data.mapper

import com.kotlincoders.nftexplorer.home.data.remote.dto.coins.CoinResult
import com.kotlincoders.nftexplorer.home.domain.model.Coin

fun CoinResult.toDomain(): Coin{
    return Coin(
        name, id, icon, rank
    )
}