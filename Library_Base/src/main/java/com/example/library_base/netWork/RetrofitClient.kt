package com.example.library_base.netWork

import androidx.lifecycle.MutableLiveData
import com.example.library_base.api.AppConstants
import com.example.library_base.BuildConfig
import okhttp3.Call
import okhttp3.EventListener
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

//网络请求
class RetrofitClient private  constructor(){

     private var retrofit: Retrofit
     private  var isLoading: MutableLiveData<Boolean>?=null


     companion object{
          val instance : RetrofitClient by lazy { RetrofitClient() }
     }
     constructor(isLoading: MutableLiveData<Boolean>):this(){
          this.isLoading=isLoading
     }
     /**
      * 类初始化的时候就开始初始化Retrofit
      */
     init {
          retrofit = Retrofit.Builder()
               .client(initClient())
               .addConverterFactory(GsonConverterFactory.create())
               .baseUrl(AppConstants.APP_DOMAIN)
               .build()

     }
     /**
      * 初始化OkHttp  添加网络设置 拦截器、加载时间等
      */
     private fun initClient(): OkHttpClient {
          return OkHttpClient.Builder()
               .proxy(Proxy.NO_PROXY)
               .addInterceptor(initLogInterceptor())
               .addInterceptor(CommonInterceptor())
               .eventListener(object : EventListener() {
                    override fun callStart(call: Call) {
                         AppConstants.isLoading.postValue(true)
                         isLoading?.postValue(true)
                         super.callStart(call)
                    }

                    override fun callEnd(call: Call) {
                         AppConstants.isLoading.postValue(false)
                         isLoading?.postValue(false)
                         super.callEnd(call)
                    }
               })
               .connectTimeout(30, TimeUnit.SECONDS)
               .readTimeout(30, TimeUnit.SECONDS)
               .build()
     }

     private fun initLogInterceptor(): HttpLoggingInterceptor {
          val loggingInterceptor = HttpLoggingInterceptor()
          if (BuildConfig.DEBUG){
               loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
          } else {
               loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
          }

          return loggingInterceptor

     }

     fun <T> create(service: Class<T>): T {
          return retrofit.create(service)
     }
     fun addLoading(isLoadings:MutableLiveData<Boolean>){
          isLoading=isLoadings
     }

}