package com.example.childmealcardfinder


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.childmealcardfinder.api.RetrofitClient
import com.example.childmealcardfinder.model.ApiResponse
import com.example.childmealcardfinder.model.ShopItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopListViewModel:ViewModel() {

    val shopList = MutableLiveData<List<ShopItem>?>()

//    val serviceKey = "tNrKaaE9TPLTmEaEn8WXYvi97SZ1Fm/Ot4pK9aGJJD/ASszhmnvEZ2xwhWE4ZcEMHGP2TamJwk+22Tg2p0MYgw=="

    fun getShopLists() = viewModelScope.launch(Dispatchers.IO) {
        RetrofitClient.shopListApi.getShopList(numOfRows = 10, pageNo = 10).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val items = response.body()?.body?.items?.itemList
                    if (items != null) {
                        shopList.postValue(items)
                        Log.e("items :", "gg{$items}" )
                        for (shop in items) {
                            Log.d("ShopListViewModel", "Shop: ${shop.shopName}")
                        }
                    } else {
                        Log.e("ShopListViewModel", "ItemList: null")
                        val responseBody = response.body()
                        if (responseBody == null) {
                            Log.e("ShopListViewModel", "Response body : null")
                        } else {
                            Log.e("ShopListViewModel", "Response body 있음. 아이템 데이터 NULL")
                            Log.e("ShopListViewModel", "Response body: $responseBody")
                        }
                    }
                } else {
                    Log.e("ShopListViewModel", "ShopListViewModel 로그: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("ShopListViewModel", "실패: ${t.message}")
            }
        })
    }

    fun getGugunLists(gugunName: String) = viewModelScope.launch(Dispatchers.IO) {
        RetrofitClient.shopListApi.getGugunList(numOfRows = 10, pageNo = 10, gugunName = gugunName).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val items = response.body()?.body?.items?.itemList
                    if (items != null) {
                        shopList.postValue(items)
                        Log.e("items :", "zz{$items}")
                        for (shop in items) {
                            Log.d("GugunListViewModel", "Shop: ${shop.shopName}")
                        }
                    } else {
                        Log.e("GugunShopListViewModel", "ItemList : null")
                        val responseBody = response.body()
                        if (responseBody == null) {
                            Log.e("GugunShopListViewModel", "Response body :null")
                        } else {
                            Log.e("GugunShopListViewModel", "Response body : not null, item list : null")
                            Log.e("GugunShopListViewModel", "Response body: $responseBody")
                        }
                    }
                } else {
                    Log.e("GugunShopListViewModel", "Response 실패 Code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("GugunShopListViewModel", "실패: ${t.message}")
            }
        })
    }

}
