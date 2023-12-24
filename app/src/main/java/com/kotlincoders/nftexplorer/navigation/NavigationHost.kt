package com.kotlincoders.nftexplorer.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kotlincoders.nftexplorer.home.presentation.home.HomeScreen
import com.kotlincoders.nftexplorer.home.presentation.nft_detail.NftDetailScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = NavigationRoute.Home.route) {
        //home
        composable(NavigationRoute.Home.route) {
            HomeScreen(onCoinDetail = {
                navHostController.navigate(NavigationRoute.Coindetail.route)
            }, onNftDetail = {
                navHostController.navigate(NavigationRoute.Nftdetail.route + "?nftAddress=$it")
            })
        }
        //coin detail
        composable(NavigationRoute.Coindetail.route) {
            Text(text = "COIN DETAIL")
        }
        //nft detail
        composable(
            NavigationRoute.Nftdetail.route + "?nftAddress={nftAddress}",
            arguments = listOf(navArgument("nftAddress") {
                type = NavType.StringType
            })
        ) {
            NftDetailScreen()
        }
    }
}

