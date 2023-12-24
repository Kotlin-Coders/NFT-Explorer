package com.kotlincoders.nftexplorer.home.domain.usecase

import com.kotlincoders.nftexplorer.home.domain.model.Nft
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class GetNftsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Nft>> {
        return repository.getTrendingNFTs()
    }
}