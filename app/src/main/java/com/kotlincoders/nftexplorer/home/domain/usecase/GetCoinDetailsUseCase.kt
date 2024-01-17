package com.kotlincoders.nftexplorer.home.domain.usecase

import com.kotlincoders.nftexplorer.home.domain.model.CoinDetails
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class GetCoinDetailsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(coinId: String): Result<CoinDetails> {
        return repository.getCoinDetails(coinId)
    }
}