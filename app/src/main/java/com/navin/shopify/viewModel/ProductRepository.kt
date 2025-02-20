package com.navin.shopify.viewModel

import com.navin.shopify.models.DataOrException
import com.navin.shopify.models.products.ProductItem
import com.navin.shopify.models.products.Products
import com.navin.shopify.network.ProductApi
import com.navin.shopify.utils.AppConstants
import okhttp3.Credentials
import javax.inject.Inject

class ProductRepository @Inject constructor(val api : ProductApi) {

    var dataOrException = DataOrException<List<ProductItem>,Boolean,Exception>()

    suspend   fun getProducts() : DataOrException<List<ProductItem>,Boolean,Exception> {

        val basic = Credentials.basic(AppConstants.Consumerkey, AppConstants.ConsumerSecret)

        try {

            dataOrException.loading=true
            dataOrException.data = api.getProducts(basic)

            if(dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading=false
            }

        }catch (e : Exception) {
            dataOrException.e = e
        }

        return  dataOrException

    }

}