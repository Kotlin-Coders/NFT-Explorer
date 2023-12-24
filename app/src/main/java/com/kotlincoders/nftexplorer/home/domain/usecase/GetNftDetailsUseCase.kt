package com.kotlincoders.nftexplorer.home.domain.usecase

import com.kotlincoders.nftexplorer.home.domain.model.NftDetails
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class GetNftDetailsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(nftAddress:String):Result<NftDetails>{
        return repository.getNftDetails(nftAddress)
    }
}