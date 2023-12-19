package com.kotlincoders.nftexplorer.home.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlincoders.nftexplorer.home.domain.usecase.GetCoinsUseCase
import com.kotlincoders.nftexplorer.home.domain.usecase.GetNftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getNftsUseCase: GetNftsUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        getAllCoinsAndNfts()
    }

    fun getAllCoinsAndNfts() {
        viewModelScope.launch {
            state = state.copy(isError = false)
            state = state.copy(isLoading = true)
            //nfts
            getNftsUseCase().onSuccess {
                state = state.copy(
                    nfts = it
                )
            }.onFailure {
                state = state.copy(
                    isError = true
                )
            }
            //coins
            getCoinsUseCase().onSuccess {
                state = state.copy(
                    coins = it
                )
            }.onFailure {
                state = state.copy(
                    isError = true
                )
            }
            state = state.copy(isLoading = false)
        }
    }
}