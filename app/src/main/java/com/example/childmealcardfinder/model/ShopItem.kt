package com.example.childmealcardfinder.model


import com.google.gson.annotations.SerializedName

data class ShopItem(
    @SerializedName("shopId") val shopId: String,
    @SerializedName("shopName") val shopName: String,
    @SerializedName("shopType") val shopType: String,
    @SerializedName("sidoName") val sidoName: String,
    @SerializedName("gunguName") val gunguName: String,
    @SerializedName("gunguCode") val gunguCode: String,
    @SerializedName("shopRoadAddr") val shopRoadAddr: String,
    @SerializedName("shopRoadAddr2") val shopRoadAddr2: String,
    @SerializedName("shopAddr") val shopAddr: String,
    @SerializedName("shopAddr2") val shopAddr2: String,
    @SerializedName("shopTel") val shopTel: String,
    @SerializedName("coRegNo") val coRegNo: String,
    @SerializedName("coSubRegNo") val coSubRegNo: String,
    @SerializedName("coOwnNm") val coOwnNm: String,
    @SerializedName("coJobSt") val coJobSt: String,
    @SerializedName("coJobStDate") val coJobStDate: String,
    @SerializedName("coFrNm") val coFrNm: String,
    @SerializedName("coFrGbn") val coFrGbn: String,
    @SerializedName("shopBsType") val shopBsType: String,
    @SerializedName("shopFaType") val shopFaType: String,
    @SerializedName("shopLat") val shopLat: String,
    @SerializedName("shopLon") val shopLon: String,
    @SerializedName("wdFrTime") val wdFrTime: String,
    @SerializedName("wdToTime") val wdToTime: String,
    @SerializedName("stFrTime") val stFrTime: String,
    @SerializedName("stToTime") val stToTime: String,
    @SerializedName("hoFrTime") val hoFrTime: String,
    @SerializedName("hoToTime") val hoToTime: String,
    @SerializedName("deliFrTime") val deliFrTime: String,
    @SerializedName("deliToTime") val deliToTime: String,
    @SerializedName("mealType") val mealType: String,
    @SerializedName("deliverYn") val deliverYn: String,
    @SerializedName("mngGoNm") val mngGoNm: String,
    @SerializedName("mngGoTel") val mngGoTel: String,
    @SerializedName("insDate") val insDate: String
)

data class Items(
    @SerializedName("item") val itemList: List<ShopItem>
)

data class Body(
    @SerializedName("items") val items: Items,
    @SerializedName("numOfRows") val numOfRows: Int,
    @SerializedName("pageNo") val pageNo: Int,
    @SerializedName("totalCount") val totalCount: Int
)

data class Header(
    @SerializedName("resultCode") val resultCode: String,
    @SerializedName("resultMsg") val resultMsg: String
)

data class ApiResponse(
    @SerializedName("header") val header: Header,
    @SerializedName("body") val body: Body
)
