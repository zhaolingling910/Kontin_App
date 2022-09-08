package com.example.library_base.netWork

import com.example.library_base.base.BaseModel
import com.example.library_base.netWork.exeption.DealException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

open  class BaseRepository() {
     private  var service: RetrofitClient?=null
     constructor(service: RetrofitClient):this(){
         this.service=service
     }


    suspend fun <T : Any> callRequest(
        call: suspend () -> NetResult<T?, Any?>
    ): NetResult<T?, Any?> {
        return try {
            call()
        } catch (e: Exception) {
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e), "")
        }

    }



    suspend fun <T : Any> handleResponse(
        response: BaseModel<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T?, Any?> {
        return coroutineScope {
            //可以根据code跳转
//            if(response.code == "40301"){
//                DataStoreUtils.clear()
//                AppManager.getAppManager().killAll()
//                ARouter.getInstance().build(ARouterCommonPath.LOGIN_PATH).navigation()
//            }
            if (response.code.equals("200")) {
                successBlock?.let { it() }
                NetResult.Success(response.data, response.mesg)
            } else {
                errorBlock?.let { it() }
                NetResult.Error(ResultException(response.code, response.mesg), response.mesg)
            }
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------
    suspend fun <T : Any> callThirdRequest(
        call: suspend () -> NetResult<T?, Any?>
    ): NetResult<T?, Any?> {
        return try {
            call()
        } catch (e: Exception) {
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e), "")
        }

    }

    suspend fun <T : Any> handleThirdResponse(
        response: T,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null): NetResult<T?, Any?> {
        return coroutineScope {

            successBlock?.let { it() }
            NetResult.ThirdResult(response)
        }


    }

 }