package com.kotlincoders.nftexplorer.home.domain.usecase

import com.kotlincoders.nftexplorer.home.domain.model.NftCollectionAssets
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository

class GetNftCollectionAssetsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(nftAddress:String):Result<List<NftCollectionAssets>>{
        return repository.getNftCollectionAssets(nftAddress)
    }

}