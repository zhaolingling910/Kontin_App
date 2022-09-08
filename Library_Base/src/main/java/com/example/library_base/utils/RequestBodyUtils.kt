package com.example.library_base.utils

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

object RequestBodyUtils {

    /**
     * @Description:    json字符串转RequestBody
     */
    fun toRequestBody(json: String): RequestBody {
        var toMediaTypeOrNull = "application/json; charset=utf-8".toMediaTypeOrNull()
        val toRequestBody = json.toRequestBody(toMediaTypeOrNull)
        return toRequestBody
    }

}
