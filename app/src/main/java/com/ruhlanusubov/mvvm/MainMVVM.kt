package com.ruhlanusubov.mvvm

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruhlanusubov.mvvm.adapter.ProductAdapter
import com.ruhlanusubov.mvvm.model.Product
import com.ruhlanusubov.mvvm.model.ProductResponse
import com.ruhlanusubov.mvvm.service.ApiUtil
import com.ruhlanusubov.mvvm.service.showToast
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMVVM:ViewModel() {

     val productList=MutableLiveData<List<Product>>()
    private val isRefreshing=MutableLiveData<Boolean>()
    private val service=ApiUtil.getService()

     fun getProduct(activity: Activity){

        viewModelScope.launch {
           productList.value=service.allProducts().body()?.products
            showToast(activity, service.allProducts().message())
        }
    }
}