package com.kotlincoders.nftexplorer.home.data.remote.dto.nfts

data class Meta(
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean,
    val itemCount: Int,
    val limit: Int,
    val page: Int,
    val pageCount: Int
)