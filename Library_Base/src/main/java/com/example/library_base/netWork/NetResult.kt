package com.example.library_base.netWork

 sealed  class NetResult <out T : Any?,out U : Any?> {
     data class Success<out T : Any?>(val data: T?, val message: String?) : NetResult<T?, Any?>()
     data class Error(val exception: ResultException, val s: String?) : NetResult<Nothing, Any?>()
     data class ThirdResult<out T : Any?>(val result: T?) : NetResult<T?, Any?>()
 }