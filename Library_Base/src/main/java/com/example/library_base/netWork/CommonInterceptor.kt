package com.example.library_base.netWork


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

//网络拦截器
class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = addHeaders(request.newBuilder())
        val response = chain.proceed(builder as Request)
        return response
    }

    //添加请求头部信息
    private fun addHeaders(builder: Request.Builder): Any {
        return builder
            .addHeader(
                "Authorization",
                "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ3ZWlyb25nd2VpIiwidXNlcklkIjoiNTg0MDYiLCJuYW1lIjoid2Vpcm9uZ3dlaSIsImxvZ2luTW9kZSI6IldFQiIsImV4cCI6MTY0MjMyMzc3NH0.Ve1_Si-DweG8CHeSxRmku6yvOx8LCoD4DPx9fojiAfn_knUTjOwe_Huk8YAsLGK35UMvC4sga-XGQMKfrNyk2HkJ5GNkncc46XX7aISDuHZzzkTOqWEBQQElF75FmUeMFViQ1ijm_GYged7DDqGKVSLrq2al711aIB_qBWPWOnc"
            )
//                .addHeader("versionCode", verName)
            .build()
    }
}
