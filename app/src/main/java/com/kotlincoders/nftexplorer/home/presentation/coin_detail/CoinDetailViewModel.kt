package com.kotlincoders.nftexplorer.home.presentation.coin_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlincoders.nftexplorer.home.domain.usecase.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(CoinDetailState())
        private set

    private val coinId = savedStateHandle.get<String>("coinId")

    init {
        getCoinDetails()
    }

    fun getCoinDetails() {
        viewModelScope.launch {
            state = state.copy(isError = false)
            state = state.copy(isLoading = true)
            if (coinId != null) {
                //coinDetails
                getCoinDetailsUseCase(coinId).onSuccess {
                    state = state.copy(
                        coinDetails = it
                    )
                }.onFailure {
                    state = state.copy(
                        isError = true
                    )
                }
            }
            state = state.copy(isLoading = false)
        }
    }

}