package com.navin.shopify.network

import com.navin.shopify.models.products.ProductItem
import com.navin.shopify.models.products.Products
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductApi {

    @GET("wp-json/wc/v3/products")
    suspend fun getProducts(@Header("Authorization") authorization:String):List<ProductItem>

}