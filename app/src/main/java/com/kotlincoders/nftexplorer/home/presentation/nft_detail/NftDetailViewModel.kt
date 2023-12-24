package com.kotlincoders.nftexplorer.home.presentation.nft_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlincoders.nftexplorer.home.domain.usecase.GetNftCollectionAssetsUseCase
import com.kotlincoders.nftexplorer.home.domain.usecase.GetNftDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NftDetailViewModel @Inject constructor(
    private val nftDetailsUseCase: GetNftDetailsUseCase,
    private val nftCollectionAssetsUseCase: GetNftCollectionAssetsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(NftDetailState())
        private set

    //    val nftAdress = "0xed5af388653567af2f388e6224dc7c4b3241c544"
    private val nftAddress = savedStateHandle.get<String>("nftAddress")
    init {
        getNftDetails()
    }

    fun getNftDetails() {
        viewModelScope.launch {
            state = state.copy(isError = false)
            state = state.copy(isLoading = true)
            if (nftAddress != null) {
                //NftDetails
                nftDetailsUseCase(nftAddress).onSuccess {
                    state = state.copy(
                        nftDetails = it
                    )
                }.onFailure {
                    state = state.copy(
                        isError = true
                    )
                }
                //NftCollectionAssets
                nftCollectionAssetsUseCase(nftAddress).onSuccess {
                    state = state.copy(
                        nftCollectionAssets = it
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