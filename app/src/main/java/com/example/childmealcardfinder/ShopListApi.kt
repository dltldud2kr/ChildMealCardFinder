package com.example.childmealcardfinder

import com.example.childmealcardfinder.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface ShopListApi {
    companion object {
        private const val authKey = "tNrKaaE9TPLTmEaEn8WXYvi97SZ1Fm/Ot4pK9aGJJD/ASszhmnvEZ2xwhWE4ZcEMHGP2TamJwk+22Tg2p0MYgw=="
    }

    // 가맹점 데이터 조회 (전체)
    @GET("getShopList")
    fun getShopList(
        @Query("serviceKey") serviceKey: String = authKey,
        @Query("type") type: String = "json",
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int
    ): Call<ApiResponse>


    // 지역별 필터 기능 (구/군별)
    @GET("getGugunList")
    fun getGugunList(
        @Query("serviceKey") serviceKey: String = authKey,
        @Query("type") type: String = "json",
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("gugunName") gugunName: String
    ): Call<ApiResponse>

}

