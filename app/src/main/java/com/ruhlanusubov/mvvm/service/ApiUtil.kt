package com.ruhlanusubov.mvvm.service

import com.ruhlanusubov.mvvm.service.Constants.BASE_URL


class ApiUtil(){

    companion object{
        fun getService():Service{
            return RetrofitClient.getClient(BASE_URL).create(Service::class.java)
        }
    }
}