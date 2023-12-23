package com.kotlincoders.nftexplorer.home.di

import com.kotlincoders.nftexplorer.home.data.remote.NftExplorerApi
import com.kotlincoders.nftexplorer.home.data.repository.HomeRepositoryImpl
import com.kotlincoders.nftexplorer.home.domain.repository.HomeRepository
import com.kotlincoders.nftexplorer.home.domain.usecase.GetCoinsUseCase
import com.kotlincoders.nftexplorer.home.domain.usecase.GetNftDetailsUseCase
import com.kotlincoders.nftexplorer.home.domain.usecase.GetNftsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Singleton
    @Provides
    fun provideNftExplorerApi(): NftExplorerApi {
        return Retrofit.Builder().baseUrl(NftExplorerApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build()).build().create(NftExplorerApi::class.java)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(
        api: NftExplorerApi
    ): HomeRepository {
        return HomeRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideCoinsUseCase(repository: HomeRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideNftsUseCase(repository: HomeRepository): GetNftsUseCase {
        return GetNftsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideNftDetailsUseCase(repository: HomeRepository): GetNftDetailsUseCase {
        return GetNftDetailsUseCase(repository)
    }

}