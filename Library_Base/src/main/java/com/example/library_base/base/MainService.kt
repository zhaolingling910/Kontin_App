package com.example.library_base.base

import com.example.library_base.bean.GoodListBean
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface MainService {
    /**
     * 获取商品列表
     */
    @POST("api/ingots/ingotSmallProduct/productList")
    suspend fun getGoodList(@Body toRequestBody: RequestBody): BaseModel<GoodListBean>

}