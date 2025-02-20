package com.navin.shopify.models

data class DataOrException<T, Boolean, E>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)
