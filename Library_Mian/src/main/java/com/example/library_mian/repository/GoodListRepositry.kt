package com.example.library_mian.repository

import com.example.library_base.base.MainService
import com.example.library_base.bean.GoodListBean
import com.example.library_base.netWork.BaseRepository
import com.example.library_base.netWork.NetResult
import com.example.library_base.netWork.RetrofitClient
import okhttp3.RequestBody

class GoodListRepository(private var service: RetrofitClient) : BaseRepository(service) {
    suspend fun getGoodList(toRequestBody: RequestBody): NetResult<GoodListBean?, Any?> {
        return callRequest(call = {
            requestGoodList(toRequestBody)
        })
    }

    private suspend fun requestGoodList(toRequestBody: RequestBody): NetResult<GoodListBean?, Any?> =
        handleResponse(service.create(MainService::class.java).getGoodList(toRequestBody))

}