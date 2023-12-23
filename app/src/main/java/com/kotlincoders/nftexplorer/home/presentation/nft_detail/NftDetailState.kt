package com.kotlincoders.nftexplorer.home.presentation.nft_detail

import com.kotlincoders.nftexplorer.home.domain.model.NftDetails

data class NftDetailState (
    val nftDetails: NftDetails? = null,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)