package com.example.library_base.bean

data class GoodListBean(
    val current: Int,
    val pages: Int,
    val records: List<SelectMallShopRecord>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class SelectMallShopRecord(
    val activityType: Int,
    val equitiesCode: String,
    val equitiesCount: String,
    val exchangeType: Int,
    val ifInventory: Int,
    val ingotCount: String,
    val originalPrice: String,
    val pic: String,
    val productId: String,
    val productName: String,
    val productType: Int,
    val status: Int,
    val stock: Int,
    val ticketCount: String,
    val drawMethod: String,
    val updatedTime: String,
    val ifEventGoods: Boolean,
    val activityInformation: String,
    val eventProductPopUpCopywriting: String

)