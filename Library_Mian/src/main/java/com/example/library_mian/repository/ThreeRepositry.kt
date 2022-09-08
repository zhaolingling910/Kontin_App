package com.example.library_mian.repository

import com.example.library_base.api.AppConstants
import com.example.library_base.base.MainService
import com.example.library_base.base.ThreeService
import com.example.library_base.bean.CustomActivityBean
import com.example.library_base.bean.GoodListBean
import com.example.library_base.netWork.BaseRepository
import com.example.library_base.netWork.NetResult
import com.example.library_base.netWork.RetrofitClient
import okhttp3.RequestBody
class ThreeRepositry(private var service: RetrofitClient) : BaseRepository(service) {
    suspend fun getThreeList(): NetResult<CustomActivityBean?, Any?> {
        return callRequest(call = {
            requestThreeList()
        })
    }

    private suspend fun requestThreeList(): NetResult<CustomActivityBean?, Any?> =
        handleThirdResponse(
            service.create(ThreeService::class.java).customActivity(ThreeService.customActivity)
        )
}