package com.example.library_base.netWork

class ResultException(var errorCode: String?, var msg: String?) : Exception(msg)