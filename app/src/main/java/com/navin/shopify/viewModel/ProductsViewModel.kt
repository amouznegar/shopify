package com.navin.shopify.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navin.shopify.models.DataOrException
import com.navin.shopify.models.products.ProductItem
import com.navin.shopify.models.products.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private  var repository: ProductRepository):ViewModel() {


    var products : MutableState<DataOrException<List<ProductItem>,Boolean,Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))


    init {
        getProducts()
    }

    private fun getProducts() {

        viewModelScope.launch {
            products.value.loading=true

            products.value =  repository.getProducts()

            if(products.value.toString().isNotEmpty()) {
                products.value.loading=false
            }

        }
    }


}