package com.example.library_base.api

import androidx.lifecycle.MutableLiveData

class AppConstants{
    companion object{

         //第一个
        const val APP_DOMAIN = "https://zpkxi.kuxiaoxiao.com/"
        //第二个
        const val Three_DOMAIN="https://yb.youpinhuihuigou.com/"



        val isLoading=MutableLiveData<Boolean>()
        val postReceiptCornerLabel=MutableLiveData<String>()
        val ingotBalanceMutable=MutableLiveData<String>()


        const val IS_AGREE_YS = "isAgreeYs" //是否同意隐私协议


        /**
         * 超级重要的一个LoadingInterface全路径，retrofit加载网络的loading就是通过这里的路径名通过反射获取到的
         */
        const val LoadingInterface="com.zhenpin.library_base.base.LoadingInterface"


        const val TOKEN = "TOKEN"
        const val OAID="android_oaid"
        const val INVITATIONCODE = "invitationCode"
        const val PhoneNumber = "phoneNumber"
        const val USERNAME="user_name"
        /**
         * 当天时间
         */
        const val DAYTIME="day_time"


        /**
         * H5分享链接
         */
//        const val H5SHAREURL = "https://test1.kuxiaoxiao.com/test/register/index.html?invitCode="
        const val H5SHAREURL = "https://zpkxi.kuxiaoxiao.com/smallh5/pin/register/index.html?invitCode="

//        const val H5SHAREURL = "https://zpkxi.kuxiaoxiao.com/smallh5/pin/register/b/index.html?invitCode="


        const val TimeOne: String = "timeOne"
        const val TimeTwo: String = "timeTwo"
    }
}