package com.ruhlanusubov.mvvm.service

import android.database.Observable
import androidx.lifecycle.Observer
import com.ruhlanusubov.mvvm.model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("products")
    suspend fun allProducts():Response<ProductResponse>
}