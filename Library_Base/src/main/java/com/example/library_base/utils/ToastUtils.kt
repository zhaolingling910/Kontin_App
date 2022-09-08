package com.example.library_base.utils

import android.app.Application
import android.content.Context
import android.widget.Toast

class ToastUtils{
    companion object instance{
        lateinit var context: Context
        fun init(contexts: Context){
            context=contexts
        }
        fun shorts(msg: String) {
            if (context == null) return
            shorts(context, msg)
        }

        fun longs(msg: String) {
            if (context == null) return
            longs(context, msg)
        }

        fun shorts(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }


        fun longs(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }


}