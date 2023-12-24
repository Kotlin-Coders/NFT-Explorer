package com.kotlincoders.nftexplorer.home.domain.usecase

import com.kotlincoders.nftexplorer.home.domain.model.Coin
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class GetCoinsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Coin>> {
        return repository.getCoins()
    }
}