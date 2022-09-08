package com.example.library_base.base

import androidx.datastore.preferences.protobuf.Api
import com.example.library_base.api.AppConstants
import com.example.library_base.bean.CustomActivityBean
import retrofit2.http.GET
import retrofit2.http.Url

//多个域名处理
interface ThreeService {
    companion object {
        const val customActivity =
            AppConstants.Three_DOMAIN + "api/CBEC-center/akc/customActivity/getAll"
    }

    @GET
    suspend fun customActivity(@Url customActivityUrl: String): CustomActivityBean
}