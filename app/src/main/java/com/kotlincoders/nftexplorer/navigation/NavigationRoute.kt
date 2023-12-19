package com.kotlincoders.nftexplorer.navigation

sealed class NavigationRoute(val route: String) {
    object Home : NavigationRoute("home")
    object Coindetail : NavigationRoute("coin_detail")
    object Nftdetail : NavigationRoute("nft_detail")
}