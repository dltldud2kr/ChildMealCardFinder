package com.example.childmealcardfinder.api

import com.example.childmealcardfinder.ShopListApi
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
//        private val gson = GsonBuilder().setLenient().create()
        private val client = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/6270000/dgMealCardShop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val shopListApi: ShopListApi = client.create(ShopListApi::class.java)

    }
}