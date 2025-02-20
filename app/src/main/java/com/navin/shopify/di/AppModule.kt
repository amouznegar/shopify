package com.navin.shopify.di

import com.navin.shopify.network.ProductApi
import com.navin.shopify.utils.AppConstants
import com.navin.shopify.viewModel.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun provideApi() : ProductApi {
        return  Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ProductApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api : ProductApi) = ProductRepository(api)

}